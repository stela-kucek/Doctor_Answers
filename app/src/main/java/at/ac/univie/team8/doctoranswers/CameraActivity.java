package at.ac.univie.team8.doctoranswers;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CameraActivity extends AppCompatActivity {


    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE_CONTENT_RESOLVER = 101;
    private ImageView imageView;
    private Uri mPhotoUri;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        imageView = (ImageView) findViewById(R.id.pictureView);

    }

    public void takePicButton(View view){
        // Alternative strategy of generating a content URI using the MediaStore
        // This way seems to work very reliably
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE_CONTENT_RESOLVER);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }

        else takePicture();
    }

    public void takePicture(){
        mPhotoUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, mPhotoUri);
        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE_CONTENT_RESOLVER);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE_CONTENT_RESOLVER: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                   takePicture();
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    CameraActivity.this.finish();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        imageView.setImageBitmap(null);

        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE_CONTENT_RESOLVER ) {
            if (resultCode == RESULT_OK) {
                // Image saved to a generated MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                String[] projection = {
                        MediaStore.MediaColumns._ID,
                        MediaStore.Images.ImageColumns.ORIENTATION,
                        MediaStore.Images.Media.DATA
                };
                Cursor c = getContentResolver().query(mPhotoUri, projection, null, null, null);
                c.moveToFirst();
                String photoFileName = c.getString(c.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));

                bitmap = BitmapFactory.decodeFile(photoFileName);
                imageView.setImageBitmap(bitmap);

            } else if (resultCode == RESULT_CANCELED) {
                // User cancelled the image capture
            } else {
                // Image capture failed, advise user
            }

        }
    }

    private void tToast(String s) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, s, duration);
        toast.show();
    }

    public void buttonAttach(View view){
        setContentView(R.layout.activity_ask_doctor);
        ImageButton imgB = (ImageButton) findViewById(R.id.attachment);
        imgB.setImageBitmap(bitmap);
        tToast("Your picture was successfully attached!");

        Button button = (Button) findViewById(R.id.button21);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText question = (EditText) findViewById(R.id.editTextQuestion);
                tToast("Your question has been sent!");
                String q = question.getText().toString();
                Intent intent = new Intent(CameraActivity.this, AfterQuestionActivity.class);
                intent.putExtra("question", q);
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.button18);
        button2.setText("Back to menu");
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CameraActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        TextView tv = (TextView) findViewById(R.id.textView34);
        tv.setText("Don't like this picture?\nTap it to take a new one!");


       imgB.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(CameraActivity.this, CameraActivity.class);
               startActivity(intent);
           }
       });



    }
}
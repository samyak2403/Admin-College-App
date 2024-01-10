package com.arrowwould.admincollegeapp.slider;

import static com.arrowwould.admincollegeapp.R.id.buttonBannerFoure;
import static com.arrowwould.admincollegeapp.R.id.buttonBannerOne;
import static com.arrowwould.admincollegeapp.R.id.buttonBannerThree;
import static com.arrowwould.admincollegeapp.R.id.buttonBannerTow;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.arrowwould.admincollegeapp.R;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import static com.arrowwould.admincollegeapp.R.id.buttonBannerFoure;
import static com.arrowwould.admincollegeapp.R.id.buttonBannerOne;
import static com.arrowwould.admincollegeapp.R.id.buttonBannerThree;
import static com.arrowwould.admincollegeapp.R.id.buttonBannerTow;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.arrowwould.admincollegeapp.R;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class SlideActivity extends AppCompatActivity {


    private Button buttonBannerone, buttonbannerTow, buttonbannerThree, buttonbannerFoure;
    private ImageView imageOne, imageTow, imageThree, imageFoure;
    private Uri bannerUriOne, bannerUriTow, bannerUriThree, bannerUriFoure;
    private FirebaseDatabase database;
    private FirebaseStorage storage;
    private final ActivityResultLauncher<Intent> starForMediaPickerResult1 = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                Intent intent = result.getData();
                if (intent != null && result.getResultCode() == Activity.RESULT_OK) {
                    bannerUriOne = intent.getData();
                    imageOne.setImageURI(bannerUriOne);

                    final StorageReference storageReference = storage.getReference().child("banner_image")
                            .child("banner_image_one");

                    storageReference.putFile(bannerUriOne).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    BannerImageModel imageModel = new BannerImageModel();
                                    imageModel.setImageOne(uri.toString());

                                    database.getReference().child("banner_image")
                                            .child("banner_one")
                                            .setValue(imageModel)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void unused) {
                                                    Toast.makeText(SlideActivity.this, "Upload Successfuly", Toast.LENGTH_SHORT).show();
                                                }
                                            }).addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {


                                                    Toast.makeText(SlideActivity.this, "Upload failure", Toast.LENGTH_SHORT).show();


                                                }
                                            });
                                }
                            });
                        }
                    });


                }
            }
    );


    private final ActivityResultLauncher<Intent> starForMediaPickerResult2 = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                Intent intent = result.getData();
                if (intent != null && result.getResultCode() == Activity.RESULT_OK) {
                    bannerUriTow = intent.getData();
                    imageTow.setImageURI(bannerUriTow);
                    final StorageReference storageReference = storage.getReference().child("banner_image")
                            .child("banner_image_tow");

                    storageReference.putFile(bannerUriTow).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    BannerImageModel imageModel = new BannerImageModel();
                                    imageModel.setImageTow(uri.toString());

                                    database.getReference().child("banner_image")
                                            .child("banner_tow")
                                            .setValue(imageModel)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void unused) {
                                                    Toast.makeText(SlideActivity.this, "Upload Successfuly", Toast.LENGTH_SHORT).show();
                                                }
                                            }).addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {


                                                    Toast.makeText(SlideActivity.this, "Upload failure", Toast.LENGTH_SHORT).show();


                                                }
                                            });
                                }
                            });
                        }
                    });


                }
            }
    );
    private final ActivityResultLauncher<Intent> starForMediaPickerResult3 = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                Intent intent = result.getData();
                if (intent != null && result.getResultCode() == Activity.RESULT_OK) {
                    bannerUriThree = intent.getData();
                    imageThree.setImageURI(bannerUriThree);


                    final StorageReference storageReference = storage.getReference().child("banner_image")
                            .child("banner_image_three");

                    storageReference.putFile(bannerUriThree).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    BannerImageModel imageModel = new BannerImageModel();
                                    imageModel.setImageThree(uri.toString());

                                    database.getReference().child("banner_image")
                                            .child("banner_three")
                                            .setValue(imageModel)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void unused) {
                                                    Toast.makeText(SlideActivity.this, "Upload Successfuly", Toast.LENGTH_SHORT).show();
                                                }
                                            }).addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {


                                                    Toast.makeText(SlideActivity.this, "Upload failure", Toast.LENGTH_SHORT).show();


                                                }
                                            });
                                }
                            });
                        }
                    });


                }
            }
    );
    private final ActivityResultLauncher<Intent> starForMediaPickerResult4 = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                Intent intent = result.getData();
                if (intent != null && result.getResultCode() == Activity.RESULT_OK) {
                    bannerUriFoure = intent.getData();
                    imageFoure.setImageURI(bannerUriFoure);

                    final StorageReference storageReference = storage.getReference().child("banner_image")
                            .child("banner_image_four");

                    storageReference.putFile(bannerUriFoure).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    BannerImageModel imageModel = new BannerImageModel();
                                    imageModel.setImageFour(uri.toString());

                                    database.getReference().child("banner_image")
                                            .child("banner_four")
                                            .setValue(imageModel)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void unused) {
                                                    Toast.makeText(SlideActivity.this, "Upload Successfully", Toast.LENGTH_SHORT).show();
                                                }
                                            }).addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {


                                                    Toast.makeText(SlideActivity.this, "Upload failure", Toast.LENGTH_SHORT).show();


                                                }
                                            });
                                }
                            });
                        }
                    });


                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);



            database = FirebaseDatabase.getInstance();
            storage = FirebaseStorage.getInstance();

            buttonBannerone = findViewById(R.id.buttonBannerOne);
            buttonbannerTow = findViewById(R.id.buttonBannerTow);
            buttonbannerThree = findViewById(R.id.buttonBannerThree);
            buttonbannerFoure = findViewById(R.id.buttonBannerFoure);

            imageOne = findViewById(R.id.imageOne);
            imageTow = findViewById(R.id.imageTow);
            imageThree = findViewById(R.id.imageThree);
            imageFoure = findViewById(R.id.imageFoure);

            buttonBannerone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    picImageOne();
                }
            });

            buttonbannerTow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    picImageTow();
                }
            });

            buttonbannerThree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    picImageThree();
                }
            });

            buttonbannerFoure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    picImageFoure();
                }
            });
        }








    private void picImageOne () {
        String[] mineTypes = {"image/png", "image/jpg", "image/jpeg"};
        ImagePicker.Companion.with(this)
                .saveDir(SlideActivity.this.getExternalFilesDir(Environment.DIRECTORY_PICTURES))
                .galleryOnly()
                .galleryMimeTypes(mineTypes)
                .crop(16f, 9f)
                .compress(512)
                .maxResultSize(1080, 1080)
                .createIntent(intent -> {
                    starForMediaPickerResult1.launch(intent);
                    return null;
                });


        // Handle the result in onActivityResult method
    }


    private void picImageTow() {
        String[] mineTypes = {"image/png", "image/jpg", "image/jpeg"};
        ImagePicker.Companion.with(this)
                .saveDir(SlideActivity.this.getExternalFilesDir(Environment.DIRECTORY_PICTURES))
                .galleryOnly()
                .galleryMimeTypes(mineTypes)
                .crop(16f, 9f)
                .compress(512)
                .maxResultSize(1080, 1080)
                .createIntent(intent -> {
                    starForMediaPickerResult2.launch(intent);
                    return null;
                });

    }

    private void picImageThree () {

        String[] mineTypes = {"image/png", "image/jpg", "image/jpeg"};
        ImagePicker.Companion.with(this)
                .saveDir(SlideActivity.this.getExternalFilesDir(Environment.DIRECTORY_PICTURES))
                .galleryOnly()
                .galleryMimeTypes(mineTypes)
                .crop(16f, 9f)
                .compress(512)
                .maxResultSize(1080, 1080)
                .createIntent(intent -> {
                    starForMediaPickerResult3.launch(intent);
                    return null;
                });


    }

    private void picImageFoure () {

        String[] mineTypes = {"image/png", "image/jpg", "image/jpeg"};
        ImagePicker.Companion.with(this)
                .saveDir(SlideActivity.this.getExternalFilesDir(Environment.DIRECTORY_PICTURES))
                .galleryOnly()
                .galleryMimeTypes(mineTypes)
                .crop(16f, 9f)
                .compress(512)
                .maxResultSize(1080, 1080)
                .createIntent(intent -> {
                    starForMediaPickerResult4.launch(intent);
                    return null;
                });


    }


}
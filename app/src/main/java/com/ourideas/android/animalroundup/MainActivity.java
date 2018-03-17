package com.ourideas.android.animalroundup;

import android.support.v7.app.AppCompatActivity;

import android.support.v7.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.ourideas.android.animalroundup.R;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private MediaPlayer animalSound;

    ImageView imageView;

    Random r;

    /** Integer[] images = {

           R.drawable.donkey,
           R.drawable.hyena,
            R.drawable.lion,

    };

    Integer[] sounds = {

            R.raw.monkey,
            R.raw.hyena,
            R.raw.lion
    }; */

    public class AnimalArray {

        public void mRrandomAnimal(int[] args) {

            /**
             * creating Animal class objects
             */

            Animal lion = new Animal(R.drawable.lion, R.raw.lion);
            Animal hyena = new Animal(R.drawable.hyena, R.raw.hyena);
            Animal donkey = new Animal(R.drawable.donkey, R.raw.monkey);


            ArrayList<Animal> arrayAnimals = new ArrayList<Animal>();
            arrayAnimals.add(lion);
            arrayAnimals.add(donkey);
            arrayAnimals.add(hyena);

        }


    }

    class Animal {
        int animalImage;
        int animalSound;
        Animal(int animalImage, int animalSound) {
            this.animalImage = animalImage;
            this.animalSound = animalSound;
        }

    }

    int currentImage = 0, lastImage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animalSound = MediaPlayer.create(this, R.raw.hyena);
        animalSound.start();

        imageView = (ImageView) findViewById(R.id.imageView);

        r = new Random();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                do {
                    currentImage = r.nextInt(images.length);


                } while (currentImage == lastImage);

                lastImage = currentImage;
                imageView.setImageResource(images[currentImage]);
            }

        });
    }
}

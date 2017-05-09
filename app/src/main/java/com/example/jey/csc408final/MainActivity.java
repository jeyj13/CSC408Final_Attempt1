package com.example.jey.csc408final;

import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import static android.R.attr.animation;
import static android.R.attr.x;
import static android.R.attr.y;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {

    int Streak = 0;
    int Wins = 0;
    String[] usedCards = {"cj.gif", "hq.gif", "sj.gif"};
    String[] fillerCards = {"c5.gif", "c7.gif", "c8.gif", "s5.gif", "s7.gif", "s8.gif"};
    Drawable cardBack;
    Drawable card1;
    Drawable card2;
    Drawable card3;
    String cheatCard = "cj.gif";
    double cheatChance = 0.0;
    boolean cheatTag = false;
    ImageButton leftCard;
    ImageButton rightCard;
    ImageButton midCard;
    int marker = 2;
    Button newRound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftCard = (ImageButton) findViewById(R.id.cardLeft);
        rightCard = (ImageButton) findViewById(R.id.cardRight);
        midCard = (ImageButton) findViewById(R.id.cardMid);
        newRound = (Button) findViewById(R.id.btnNew);


       // RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_main);
   //     final float midCardX = midCard.getX();
       final  float midCardY = midCard.getY();
      // final float leftCardX = leftCard.getX();
      final  float leftCardY = leftCard.getY();
     // final  float rightCardX = rightCard.getX();
      final  float rightCardY = rightCard.getY();
        cardBack = getResources().getDrawable(R.drawable.b1fv);
        card1 = getResources().getDrawable(R.drawable.cj);
        card2 = getResources().getDrawable(R.drawable.hq);
        card3 = getResources().getDrawable(R.drawable.sj);
        newRound.setOnClickListener((new View.OnClickListener() {
            public void onClick(View V) {
               // midCard.setImageDrawable(cardBack);
               // leftCard.setImageDrawable(cardBack);
              //  rightCard.setImageDrawable(cardBack);
                reshuffler(leftCard, midCard, rightCard, leftCardY, midCardY, rightCardY);
            }
        }));
    }
    public void onImageButtonClick(View v) {
       ImageButton button = (ImageButton) v;
       // String bText = button.getText().toString();
       // cheatingDealer(cheatChance);

        if (button == (ImageButton)findViewById(R.id.cardLeft))
        {
            if(marker == 1 && cheatTag == false)
            {
                leftCard.setImageDrawable(card2);
            }
            else if (marker != 1)
            {
                leftCard.setImageDrawable(card3);
            }
            else if (marker == 1 && cheatTag == true)
            {
                leftCard.setImageDrawable(card1);
            }
        }
        else if (button == (ImageButton)findViewById(R.id.cardMid))
        {
            if(marker == 2)
            {
                midCard.setImageDrawable(card2);
            }
            else if (marker != 2)
            {
                midCard.setImageDrawable(card1);
            }
            else if (marker == 1 && cheatTag == true)
        {
            midCard.setImageDrawable(card3);
        }
        }
        else if (button == (ImageButton)findViewById(R.id.cardRight))
        {
            if(marker == 3)
            {
                rightCard.setImageDrawable(card2);
            }
            else if (marker != 3)
            {
                rightCard.setImageDrawable(card1);
            }
            else if (marker == 1 && cheatTag == true)
        {
            rightCard.setImageDrawable(card3);
        }
        }
    }

    // private void newRound_OnClick(){


    private void cheatingDealer(double n) {
        double mathifier = Math.random();
        if (n > 0 && n < 0.1) {
           // mathifier = Math.random();
            if (mathifier < 0.2) {

            } else if (mathifier >= 0.3 && mathifier < 0.31) {
                cheatTag = true;
            } else {

            }
        } else if (n >= 0.1 && n < 0.2) {

           // mathifier = Math.random();
            if (mathifier < 0.3) {

            } else if (mathifier >= 0.3 && mathifier < 0.33) {
                cheatTag = true;
            } else {

            }

        } else if (n >= 0.2 && n < 0.3) {

         //   mathifier = Math.random();
            if (mathifier < 0.3) {

            } else if (mathifier >= 0.3 && mathifier < 0.36) {
                cheatTag = true;
            } else {

            }

        } else if (n >= 0.3 && n < 0.4) {

           // mathifier = Math.random();
            if (mathifier < 0.3) {

            } else if (mathifier >= 0.3 && mathifier < 0.4) {
                cheatTag = true;
            } else {

            }

        } else if (n >= 0.4 && n < 0.5) {

          //  mathifier = Math.random();
            if (mathifier < 0.3) {

            } else if (mathifier >= 0.3 && mathifier < 0.5) {
                cheatTag = true;
            } else {

            }

        } else if (n >= 0.6 && n < 0.7) {

           // mathifier = Math.random();
            if (mathifier < 0.5) {
                cheatTag = true;
            } else {

            }

        } else if (n >= 0.7 && n < 0.8) {

           // mathifier = Math.random();
            if (mathifier < 0.5) {
                cheatTag = true;
            } else {

            }

        } else if (n >= 0.8 && n < 0.9) {

          //  mathifier = Math.random();
            if (mathifier < 0.6) {
                cheatTag = true;
            } else {

            }

        } else if (n >= 0.9 && n < 1.0) {

            //mathifier = Math.random();
            if (mathifier < 0.7) {
                cheatTag = true;
            } else {

            }

        } else if (n >= 1.0) {

            cheatTag = true;

        }


    }

    private void reshuffler(ImageButton a, ImageButton b, ImageButton c, float y1,  float y2, float y3) {
       /* int specialCount = 0;
        for (int l = 2; l < 100; l++)
        {
            if(l/5 > 2 && l/5<4)
            {
                l+=3;
                specialCount += (l*6+1)-2;
            }
            else if (l*2<100 && l/2 >1 && l*2 >10)
            {
                l*=2;
                specialCount=l-1;
            }
            else if (l<99 && l+1 <99 && l*12 < 40)
            {
                l*=12;
                if(l%2 == 0)
                {
                    specialCount-=1;
                }
                else if(l%3 == 0)
                {
                    specialCount-=1;
                }
                else
                {
                    specialCount-=2;
                }
            }
            if(specialCount%2 == 0)
            {
                specialCount = (specialCount/2);
            }
            else
            {
                specialCount = (specialCount/2) + 1;
            }
            marker = l/specialCount;
            if (marker > 3)
            {
                for(int j = 0; j<marker+1;j++)
                {
                    marker-=1;
                    if(marker<=3)
                    {
                        j=marker+1;
                    }
                    else
                    {

                    }
                }

            }
            else if (marker <=-1)
            {
                marker = 2;
            }*/

      //  shuffle(a,b,x1,x2,y1,y2);
        for (int d = 0; d < 24; d++) {
            double mathification = Math.random();
            double thedivider = Math.random();
            double toomanylevels = Math.random();
            if (mathification < 0.5) {

                    if (toomanylevels < 0.3) {
                        shuffle(a, b, y1, y2);
                    } else if (toomanylevels >= 0.3 && toomanylevels < 0.6) {
                        shuffle(a, c, y1, y3);
                    } else if (toomanylevels >= 0.6) {
                        shuffle(b, c, y2, y3);
                    }

            } else if (mathification >= 0.5) {
                if (toomanylevels < 0.3) {
                    shuffle(a, c, y1, y3);
                } else if (toomanylevels >= 0.3 && toomanylevels < 0.6) {
                    shuffle(b, c, y2, y3);
                } else if (toomanylevels >= 0.6) {
                    shuffle(a, b, y1, y2);
                }
            }
        }
    }



    private void shuffle (ImageButton a, ImageButton b, float y1, float y2){
        ObjectAnimator oa = ObjectAnimator.ofFloat(a, "translationY", y1, y2);
        ObjectAnimator oa2 = ObjectAnimator.ofFloat(b, "translationY", y2, y1);
       // oa = ObjectAnimator
        oa.setDuration(1000);
        oa2.setDuration(1000);
        oa.start();
        oa2.start();
       // MoveButton(a, x1,x2,y1,y2);
       // MoveButton(b, x2,x1,y2,y1);
        /*TranslateAnimation animation1 = new TranslateAnimation(x1, x2,
                y1, y2);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation1.setDuration(2000);  // animation duration
        TranslateAnimation animation2 = new TranslateAnimation(x2, x1,
                y2, y1);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation2.setDuration(2000);  // animation duration
        a.startAnimation(animation1);
        b.startAnimation(animation2);
        a.animate().translationX(x2).translationY(y2).start();
        b.animate().translationX(x1).translationY(y1).start();*/
       // animation1.start();
       // animation2.start();

    }
    public void MoveButton(final View view, float x1, float x2, float y1, float y2) {
        TranslateAnimation anim = new TranslateAnimation(x1,x2,y1,y2);

        anim.setDuration(3000);
        anim.setFillAfter(true);

        anim.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }
        });

        view.startAnimation(anim);

    }
}

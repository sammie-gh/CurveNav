package com.gh.sammie.myapplicationcurvedbottom;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.sdsmdg.harjot.vectormaster.VectorMasterView;
import com.sdsmdg.harjot.vectormaster.models.PathModel;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    CurvedBottomNavigationView bottomNavigationView;
    VectorMasterView fab1,fab2,fab;
    RelativeLayout lin_id;
    PathModel outline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //view
        bottomNavigationView = findViewById(R.id.bottom_nav);
        fab = findViewById(R.id.fab);
        fab1 = findViewById(R.id.fab1);
        fab2 = findViewById(R.id.fab2);


        lin_id = findViewById(R.id.lin_id);
        bottomNavigationView.inflateMenu(R.menu.main_menu);

        //set event button
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_shopping:
                Toast.makeText(this, "click to cart", Toast.LENGTH_SHORT).show();

                //animation
                draw(6);
                lin_id.setX(bottomNavigationView.mFirstCurveControlPoint1.x);
                fab.setVisibility(View.VISIBLE);
                fab1.setVisibility(View.GONE);
                fab2.setVisibility(View.GONE);
                drawAnimation(fab);

                break;

            case R.id.action_shipping:
                Toast.makeText(this, "click to shpping", Toast.LENGTH_SHORT).show();

                //animation
                draw(2);
                lin_id.setX(bottomNavigationView.mFirstCurveControlPoint1.x);
                fab.setVisibility(View.GONE);
                fab1.setVisibility(View.VISIBLE);
                fab2.setVisibility(View.GONE);
                drawAnimation(fab1);

                break;

            case R.id.action_customer:
                Toast.makeText(this, "click to customer", Toast.LENGTH_SHORT).show();

                //animation
                draw();
                lin_id.setX(bottomNavigationView.mFirstCurveControlPoint1.x);
                fab.setVisibility(View.GONE);
                fab1.setVisibility(View.GONE);
                fab2.setVisibility(View.VISIBLE);
                drawAnimation(fab2);

                break;
        }
        return true;
    }

    private void draw() {

        bottomNavigationView.mFirstCurveStartPoint.set((bottomNavigationView.mNavigationBarWidth *10/12)
        -(bottomNavigationView.CURVE_CIRCLE_RADIUS *2)
        -(bottomNavigationView.CURVE_CIRCLE_RADIUS/3),0);


        bottomNavigationView.mFirstCurveEndPoint.set(bottomNavigationView.mNavigationBarWidth *10/12 ,
                bottomNavigationView.CURVE_CIRCLE_RADIUS
                + (bottomNavigationView.CURVE_CIRCLE_RADIUS/4 ));

        bottomNavigationView.mSecondCurveStartPoint = bottomNavigationView.mFirstCurveEndPoint;
        bottomNavigationView.mSecondCurveEndPoint.set((bottomNavigationView.mNavigationBarWidth * 10/12)
                + (bottomNavigationView.CURVE_CIRCLE_RADIUS*2) + (bottomNavigationView.CURVE_CIRCLE_RADIUS/3),0);

        bottomNavigationView.mFirstCurveControlPoint1.set(bottomNavigationView.mFirstCurveStartPoint.x
                + bottomNavigationView.CURVE_CIRCLE_RADIUS + (bottomNavigationView.CURVE_CIRCLE_RADIUS/4),bottomNavigationView.mFirstCurveStartPoint.y);

        bottomNavigationView.mFirstCurveControlPoint2.set(bottomNavigationView.mFirstCurveEndPoint.x -
                        (bottomNavigationView.CURVE_CIRCLE_RADIUS*2) + bottomNavigationView.CURVE_CIRCLE_RADIUS,
                bottomNavigationView.mFirstCurveEndPoint.y);

        //same with second
        bottomNavigationView.mSecondCurveControlPoint1.set(bottomNavigationView.mSecondCurveStartPoint.x
                        + ( bottomNavigationView.CURVE_CIRCLE_RADIUS*2 ) - bottomNavigationView.CURVE_CIRCLE_RADIUS,
                bottomNavigationView.mSecondCurveStartPoint.y);

        bottomNavigationView.mSecondCurveControlPoint2.set(bottomNavigationView.mSecondCurveEndPoint.x -
                (bottomNavigationView.CURVE_CIRCLE_RADIUS + (bottomNavigationView.CURVE_CIRCLE_RADIUS/4)) ,bottomNavigationView.mSecondCurveEndPoint.y);

    }


    private void draw(int i) {
        bottomNavigationView.mFirstCurveStartPoint.set((bottomNavigationView.mNavigationBarWidth/i)-
                (bottomNavigationView.CURVE_CIRCLE_RADIUS*2)- (bottomNavigationView.CURVE_CIRCLE_RADIUS/3),0);

        bottomNavigationView.mFirstCurveEndPoint.set(bottomNavigationView.mNavigationBarWidth/i , bottomNavigationView.CURVE_CIRCLE_RADIUS
        + (bottomNavigationView.CURVE_CIRCLE_RADIUS/4 ));

        bottomNavigationView.mSecondCurveStartPoint = bottomNavigationView.mFirstCurveEndPoint;
        bottomNavigationView.mSecondCurveEndPoint.set((bottomNavigationView.mNavigationBarWidth/i)
        + (bottomNavigationView.CURVE_CIRCLE_RADIUS*2) + (bottomNavigationView.CURVE_CIRCLE_RADIUS/3),0);

        bottomNavigationView.mFirstCurveControlPoint1.set(bottomNavigationView.mFirstCurveStartPoint.x
        + bottomNavigationView.CURVE_CIRCLE_RADIUS + (bottomNavigationView.CURVE_CIRCLE_RADIUS/4),bottomNavigationView.mFirstCurveStartPoint.y);

        bottomNavigationView.mFirstCurveControlPoint2.set(bottomNavigationView.mFirstCurveEndPoint.x -
                (bottomNavigationView.CURVE_CIRCLE_RADIUS*2) + bottomNavigationView.CURVE_CIRCLE_RADIUS,
                bottomNavigationView.mFirstCurveEndPoint.y);

        //same with second
        bottomNavigationView.mSecondCurveControlPoint1.set(bottomNavigationView.mSecondCurveStartPoint.x
                + ( bottomNavigationView.CURVE_CIRCLE_RADIUS*2 ) - bottomNavigationView.CURVE_CIRCLE_RADIUS,
                bottomNavigationView.mSecondCurveStartPoint.y);

        bottomNavigationView.mSecondCurveControlPoint2.set(bottomNavigationView.mSecondCurveEndPoint.x -
                (bottomNavigationView.CURVE_CIRCLE_RADIUS + (bottomNavigationView.CURVE_CIRCLE_RADIUS/4)) ,bottomNavigationView.mSecondCurveEndPoint.y);




    }

    private void drawAnimation(final VectorMasterView fab) {
        outline = fab.getPathModelByName("outline");
        outline.setStrokeColor(Color.WHITE);
        outline.setTrimPathEnd(0.0f);

        //init valueanimator
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.0f,1.0f);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                outline.setTrimPathEnd((Float)valueAnimator.getAnimatedValue());
                fab.update();
            }
        });

        valueAnimator.start();
    }


}

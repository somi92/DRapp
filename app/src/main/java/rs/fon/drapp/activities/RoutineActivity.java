package rs.fon.drapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import rs.fon.drapp.R;
import rs.fon.drapp.domain.Routine;
import rs.fon.drapp.domain.RoutineStep;
import rs.fon.drapp.loaders.AssetsManager;

public class RoutineActivity extends AppCompatActivity {

    private ImageView mImage;
    private TextView mDescTV;
    private Button mPreviousButton;
    private Button mNextButton;
    private Button mSoundButton;

    private Routine mRoutine;

    private StepHandler mStepHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);

        mImage = (ImageView) findViewById(R.id.imgRoutineStep);
        mDescTV = (TextView) findViewById(R.id.step_desc);
        mPreviousButton = (Button) findViewById(R.id.btnPrevious);
        mNextButton = (Button) findViewById(R.id.btnNext);
        mSoundButton = (Button) findViewById(R.id.btnSound);

        Intent intent = getIntent();
        mRoutine = (Routine) intent.getExtras().getSerializable("routine");

        mStepHandler = new StepHandler(mRoutine.getSteps());
        mImage.setImageDrawable(AssetsManager.getInstance().getDrawableAsset(this, mStepHandler.getStep().getImageResource()));
        mDescTV.setText(mStepHandler.getStep().getDescription());

        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImage.setImageDrawable(AssetsManager.getInstance()
                        .getDrawableAsset(RoutineActivity.this, mStepHandler.previousStep().getStep().getImageResource()));
                mDescTV.setText(mStepHandler.getStep().getDescription());
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImage.setImageDrawable(AssetsManager.getInstance()
                        .getDrawableAsset(RoutineActivity.this, mStepHandler.nextStep().getStep().getImageResource()));
                mDescTV.setText(mStepHandler.getStep().getDescription());
            }
        });

        mSoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AssetsManager.getInstance().playSound(RoutineActivity.this, mStepHandler.getStep().getAudioResource());
            }
        });
    }

    private class StepHandler {

        private List<RoutineStep> steps;
        private int currentStep;
        private int maxStep;

        private StepHandler(List<RoutineStep> steps) {
            this.steps = steps;
            currentStep = 0;
            maxStep = this.steps.size();
        }

        private StepHandler nextStep() {
            currentStep++;
            if(currentStep == maxStep) {
                currentStep--;
            }
            return this;
        }

        private StepHandler previousStep() {
            currentStep--;
            if(currentStep < 0) {
                currentStep++;
            }
            return this;
        }

        private RoutineStep getStep() {
            RoutineStep result = steps.get(currentStep);
            return result;
        }

        private StepHandler resetSteps() {
            currentStep = 0;
            maxStep = steps.size();
            return this;
        }
    }
}

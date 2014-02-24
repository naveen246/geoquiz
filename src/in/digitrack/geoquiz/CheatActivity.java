package in.digitrack.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends Activity {
	
	private Button mShowAnswerButton;
	private TextView mAnswerTextView;
	private boolean mAnswerIsTrue;
	boolean mIsAnswerShown;
	public static final String EXTRA_ANSWER_IS_TRUE = "in.digitrack.geoquiz.answer_is_true";
	public static final String EXTRA_ANSWER_SHOWN = "in.digitrack.geoquiz.answer_shown";
	public static final String KEY_ANSWER_SHOWN = "answer_shown";
	
	public void setAnswerShownResult() {
		Intent data = new Intent();
		data.putExtra(EXTRA_ANSWER_SHOWN, mIsAnswerShown);
		setResult(RESULT_OK, data);
	}
	
	public void showAnswer() {
		if(mAnswerIsTrue) {
			mAnswerTextView.setText(R.string.true_button);
		} else {
			mAnswerTextView.setText(R.string.false_button);
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cheat);
		
		mShowAnswerButton = (Button)findViewById(R.id.showAnswerButton);
		mAnswerTextView = (TextView)findViewById(R.id.answerTextView);
		mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
		
		mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showAnswer();
				mIsAnswerShown = true;
				setAnswerShownResult();
			}
		});
		
		if(savedInstanceState != null) {
			mIsAnswerShown = savedInstanceState.getBoolean(KEY_ANSWER_SHOWN, false);
			if(mIsAnswerShown) {
				showAnswer();
				setAnswerShownResult();
			}
		}
	}
	
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putBoolean(KEY_ANSWER_SHOWN, mIsAnswerShown);
	}
}

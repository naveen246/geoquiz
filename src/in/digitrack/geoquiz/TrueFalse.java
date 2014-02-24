package in.digitrack.geoquiz;

public class TrueFalse {
	private int mQuestion;
	private boolean mTrueQuestion;
	
	public TrueFalse(int question, boolean trueQuestion) {
		mQuestion = question;
		mTrueQuestion = trueQuestion;
	}
	
	public void setQuestion(int question) {
		mQuestion = question;
	}
	
	public int getQuestion() {
		return mQuestion;
	}
	
	public void setTrueQuestion(boolean trueQuestion) {
		mTrueQuestion = trueQuestion;
	}
	
	public boolean isTrueQuestion() {
		return mTrueQuestion;
	}
}

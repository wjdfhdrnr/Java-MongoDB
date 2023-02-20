package cls;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 10명의 학생의 국어 점수를 보관하고 처리할 클래스 
@Setter
@Getter
@ToString
public class KorScore {

	private String[] student = new String[5];
	private int[] score = new int[5];

	// getter, setter, toString 메소드가 존재함.(위에 @로 import해놓음)

	// [전체 합계구하기]
	// Main7에서 이미 데이터를 넣어줬기 때문에 sumScore()안에 받아올 값 선언 안해도됨
	public int sumScore() {
		int sum = 0;
		int i; // 반복문용 임시변수
		for (i = 0; i < this.score.length; i++) {
			sum += this.score[i];
		}
		return sum;
	}

	// [평균 구하기]
	public float avgScore() {
		float avg = 0.0f;
		int sum = this.sumScore();
		
		avg = (float)sum / this.score.length;
		
		return avg;
	}

	// [최대점수 구하기]
	public int scoreMax() {
		int max = this.score[0]; // 첫번째 값으로 초기화 // 20
		int i;
		for(i = 0; i < this.score.length; i++) {
			if(this.score[i]>max) {
				max=this.score[i];
			}
		}
		return max;
	}

	// [최소점수 구하기]
	public int scoreMin() {
		int min = this.score[0];
		int i;
		for(i = 0; i < this.score.length; i++) {
			if(this.score[i]<min) {
				min=this.score[i];
			}
		}
		return min;
	}
	
	// [90점 이상인 사람 수]
	public int score90() {
		int cnt=0;
		int i;
		for(i=0; i<this.score.length; i++) {
			if(this.score[i]>=90) {
				cnt+=1;
			}
		}
		
		return cnt;
	}

}

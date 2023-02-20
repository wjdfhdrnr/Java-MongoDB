package day7;

public class Child2 extends Parent {

	@Override // 이 메소드는 기능을 재정의 할 것임.
	public void work() {
		// 부모 기능 사용x(super x) => 재정의
		System.out.println("child2 work");
	}

}

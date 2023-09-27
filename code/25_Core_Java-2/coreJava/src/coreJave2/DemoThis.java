package coreJave2;

public class DemoThis {
	int a = 3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemoThis demoThis = new DemoThis();
		demoThis.method();
	}

	public void method() {
		int a =1;
		System.out.println(a);
		System.out.println(this.a);
		System.out.println(a+this.a);
		// this keyword refers to current object -> object scope lies in class level
	}
}

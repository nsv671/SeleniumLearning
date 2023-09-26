package packageInterface;

public class IndianTraficRule implements CentralTrafic, ContinentalTraficRule{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CentralTrafic centralTrafic = new IndianTraficRule(); // this object only have the CentralTrafic interface method
		
		centralTrafic.goGreen();
		centralTrafic.stopRed();
		centralTrafic.slowYello();
		
		ContinentalTraficRule continentalTraficRule = new IndianTraficRule(); // this object only have the ContinentalTraficRule interface method
		continentalTraficRule.trainSymbol();
		
		IndianTraficRule indianTraficRule = new IndianTraficRule(); // this object have all the method present in the implemented interface and it's own methods also
		indianTraficRule.handSymbol();
	}
	
	public void handSymbol() {
		System.out.println("hand symbol for walking");
	}

	@Override
	public void goGreen() {
		// TODO Auto-generated method stub
		System.out.println("goGreen implemented");
	}

	@Override
	public void stopRed() {
		// TODO Auto-generated method stub
		System.out.println("stopRed implemented");
	}

	@Override
	public void slowYello() {
		// TODO Auto-generated method stub
		System.out.println("slowYello implemented");
	}

	@Override
	public void trainSymbol() {
		// TODO Auto-generated method stub
		System.out.println("trainSymbol implemented");
	}

}

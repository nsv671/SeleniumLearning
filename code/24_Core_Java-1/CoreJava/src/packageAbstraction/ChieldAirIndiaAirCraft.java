package packageAbstraction;

public class ChieldAirIndiaAirCraft extends ParentAirCraft {

	// TODO Auto-generated method stub
	public static void main(String[] args) {
		// we won't be able to create oject of a abstract class
		//ParentAirCraft parentAircraft = new ParentAirCraft()
		
		ChieldAirIndiaAirCraft airIndiaAirCraft = new ChieldAirIndiaAirCraft();
		
		airIndiaAirCraft.engine();
		airIndiaAirCraft.seftyGuidLine();
		airIndiaAirCraft.bodyColor();
	}

	@Override
	public void bodyColor() {
		// TODO Auto-generated method stub
		System.out.println("Air India air craft body color is RED");
	}

}

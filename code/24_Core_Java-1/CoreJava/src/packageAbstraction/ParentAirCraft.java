package packageAbstraction;

public abstract  class ParentAirCraft {

	
	// except private any other access modifier we can use
		public void engine() {
			System.out.println("Follow Engine guid line");
		}
		
		public void seftyGuidLine() {
			System.out.println("Follow sefty guid line");
		}
		
		public abstract void bodyColor();

}

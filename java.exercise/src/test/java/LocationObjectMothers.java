

public class LocationObjectMothers {

	public static LocationObjectMother NewOrleans() {
		// TODO Auto-generated method stub
		return new LocationBuilder()
				.withState(States.Louisiana)
				.withCity(Cities.NewOrleans)
				.build();
	}
	
	public static LocationObjectMother Houston() {
		// TODO Auto-generated method stub
		return new LocationBuilder()
				.withState(States.Texas)
				.withCity(Cities.Houston)
				.build();
	}
	
	public static LocationObjectMother SanDiego() {
		// TODO Auto-generated method stub
		return new LocationBuilder()
				.withState(States.California)
				.withCity(Cities.SanDiego)
				.build();
	}
	
	public static LocationObjectMother NewYork() {
		// TODO Auto-generated method stub
		return new LocationBuilder()
				.withState(States.NewYork)
				.withCity(Cities.NewYork)
				.build();
	}

}

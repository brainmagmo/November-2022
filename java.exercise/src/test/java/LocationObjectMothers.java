

public class LocationObjectMothers {

	public static LocationObjectMother NewOrleans() {
		return new LocationBuilder()
				.withState(States.Louisiana)
				.withCity(Cities.NewOrleans)
				.build();
	}
	
	public static LocationObjectMother Houston() {
		return new LocationBuilder()
				.withState(States.Texas)
				.withCity(Cities.Houston)
				.build();
	}
	
	public static LocationObjectMother SanDiego() {
		return new LocationBuilder()
				.withState(States.California)
				.withCity(Cities.SanDiego)
				.build();
	}
	
	public static LocationObjectMother NewYork() {
		return new LocationBuilder()
				.withState(States.NewYork)
				.withCity(Cities.NewYork)
				.build();
	}

}

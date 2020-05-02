package bankspp;

public interface IBaseRate {
	//write a method that return the base rate
	default double getBaseRate() {
		return 2.5;
	}
}

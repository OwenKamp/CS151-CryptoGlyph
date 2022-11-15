
public class PrimesNotCalculatedException extends Exception {
	public PrimesNotCalculatedException(){
		super("Prime numbers array needs to be calculated first before it can be accessed");
	}
}

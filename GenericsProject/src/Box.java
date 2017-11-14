
/**
	The most commonly used type parameter names are:
	
	E - Element (used extensively by the Java Collections Framework)
	K - Key
	N - Number
	T - Type
	V - Value
	S,U,V etc. - 2nd, 3rd, 4th types 
 *
 */

public class Box<T>{
	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
	// <U extends Number> adds bounding to the U type.  It can be an integer or double but not string
	public <U extends Number> void inspect(U u){
		System.out.println("T: " + 	obj.getClass().getName());
		System.out.println("U: " + 	u.getClass().getName());
	}
}

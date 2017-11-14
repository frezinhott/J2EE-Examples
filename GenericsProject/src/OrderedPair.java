
public class OrderedPair<K, V> implements Pair<K, V> {

	private K key;
	private V value;
	
	OrderedPair(K key, V value){
		this.key=key;
		this.value=value;
	}
	
	@Override
	public K getKey() {
		return this.key;
	}

	@Override
	public V getValue() {
		return this.value;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	

}

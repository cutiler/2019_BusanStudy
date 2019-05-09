package generictest;

public class Util {
	
	public <K,V> V utilCall(Pair<K, V> p){
		return p.getValue();
	}
	

}

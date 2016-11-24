package swtVorlesung;
import java.util.Stack;
import java.util.function.*;

public class Stapel {
	Stapel predecessor;
	Integer item;

	private Stapel(Stapel precessor, Integer item){
		this.predecessor = precessor;
		this.item = item;
	}
		
		
	public Stapel() {
		this(null, null);
	}
	
	Stapel push(Integer item){
		return new Stapel(this, item);
	}
	
	Stapel add(){
		Integer x = this.predecessor.item;
		Integer y = this.item;
		return this.predecessor.predecessor.push(x + y);
	}
	
	Stapel op(BiFunction<Integer, Integer, Integer> f){
		Integer x = this.predecessor.item;
		Integer y = this.item;
		return this.predecessor.predecessor.push(f.apply(x, y));
	}
		

}

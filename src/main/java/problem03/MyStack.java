package problem03;

public class MyStack {
	
	private String[] buffer;
	private int idx;

	public MyStack( int size ) {
		buffer = new String[size];
		idx = 0;
	}
	
	public void push(String item) {
		if(idx>=buffer.length)
			buffer = resizing();
		
		buffer[idx++]=item;
	}
	
	public String pop() {
		if(idx==0)
			throw new IndexOutOfBoundsException("스택이 비어있습니다.");
		
		String temp = buffer[--idx];
		buffer[idx] = null;
		
		return temp;
	}

	public boolean isEmpty() {
		return idx==0? true:false;
	}
	
	public int size() {
		return idx;
	}
	
	private String[] resizing() {
		String[] newBuffer = new String[buffer.length+10];
		System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
				
		return newBuffer;
	}
}
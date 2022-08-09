package com.day0808;

public class SooStack<E> implements IStack<E>{

	private Node<E> top; // 더미노드 아님!!
	
	@Override
	public void push(E data) { // 첫 놰드 삽입 알고리즘
		top = new Node<E>(data, top); // 들어온 애는 top이 되고 전에 top이었던 애를 연결함
	}

	@Override
	public E pop() {
		if(isEmpty()) {
			System.out.println("공백 스택이어서 작업이 불가능합니다.");
			return null;
		}
		Node<E> popNode = top;
		top = popNode.link;
		popNode.link = null;
		
		return popNode.data;
	}

	@Override
	public E peek() {
		if(isEmpty()) {
			System.out.println("공백 스택이어서 작업이 불가능합니다.");
			return null;
		}
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int size() {
		int cnt = 0;
		for(Node<E> n=top; n!=null; n=n.link) {
			++cnt;
		}
		return cnt;
	}

}

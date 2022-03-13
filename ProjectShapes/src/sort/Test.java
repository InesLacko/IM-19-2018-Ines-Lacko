package sort;

import java.awt.EventQueue;

import stack.StackFrame;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortFrm sortfrm = new SortFrm();
					sortfrm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}

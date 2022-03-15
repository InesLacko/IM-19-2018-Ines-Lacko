package sort;

import java.awt.EventQueue;

public class Test {

	public static void main(String[] args) {
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

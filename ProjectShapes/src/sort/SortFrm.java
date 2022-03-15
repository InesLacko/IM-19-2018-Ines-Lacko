package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import stack.DialogStack;
import geometry.Point;
import geometry.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class SortFrm extends JFrame {

	private JPanel contentPane;
	DefaultListModel<Rectangle> defaultListModel = new DefaultListModel<>();
	private JList<Rectangle> list;
	
	/**
	 * Create the frame.
	 */
	public SortFrm() {
		setTitle("Ines Lacko IM 19/18");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogStack dialog = new DialogStack();
				dialog.setVisible(true);

				if (dialog.checkAll) {
					Rectangle r = new Rectangle(
							new Point(Integer.parseInt(dialog.getTextFieldX().getText().toString()),
									Integer.parseInt(dialog.getTextFieldY().getText().toString())),
							(Integer.parseInt(dialog.getTextFieldHeight().getText().toString())),
							(Integer.parseInt(dialog.getTextFieldWidth().getText().toString())));

					defaultListModel.add(0,r);
				}
			}
		});
		panel.add(btnAdd);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rectangle[] rect = new Rectangle[defaultListModel.getSize()];
				for (int i = 0; i < rect.length; i++) {
					rect[i] = defaultListModel.getElementAt(i);
				}

				Arrays.sort(rect);
				defaultListModel.clear();
				for (int i = 0; i < rect.length; i++) {
					defaultListModel.addElement(rect[i]);
				}
			}
		});
		panel.add(btnSort);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
	}

}

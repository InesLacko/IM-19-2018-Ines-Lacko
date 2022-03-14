package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StackFrame extends JFrame {

	private JPanel contentPane;
	DefaultListModel<Rectangle> defaultListModel = new DefaultListModel<Rectangle>();
	private JList<Rectangle> list;

	/**
	 * Create the frame.
	 */
	public StackFrame() {
		setTitle("Ines Lacko IM 19/18");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogStack dialogCreate = new DialogStack();
				dialogCreate.setVisible(true);

				if (dialogCreate.checkAll) {
					Rectangle r = new Rectangle(
							new Point(Integer.parseInt(dialogCreate.getTextFieldX().getText().toString()),
									Integer.parseInt(dialogCreate.getTextFieldY().getText().toString())),
							(Integer.parseInt(dialogCreate.getTextFieldHeight().getText().toString())),
							(Integer.parseInt(dialogCreate.getTextFieldWidth().getText().toString())));

					defaultListModel.add(0, r);
				}
			}
		});
		panel.add(btnCreate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogStack dialogCreate = new DialogStack();
				
				if (!defaultListModel.isEmpty()) {
					defaultListModel.remove(0);

				} else {
					JOptionPane.showMessageDialog(contentPane, "There is no element to delete", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnDelete);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(defaultListModel);
	}

}

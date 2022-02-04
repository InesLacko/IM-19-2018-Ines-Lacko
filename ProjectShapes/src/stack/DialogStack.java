package stack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Rectangle;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogStack extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldHeight;
	private JTextField textFieldWidth;
	public boolean checkAll;

	/**
	 * Create the dialog.
	 */
	public DialogStack() {
		setTitle("Ines Lacko IM 19/18");
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXUpperLeft = new JLabel("x cordinate upper left");
			GridBagConstraints gbc_lblXUpperLeft = new GridBagConstraints();
			gbc_lblXUpperLeft.anchor = GridBagConstraints.EAST;
			gbc_lblXUpperLeft.insets = new Insets(0, 0, 5, 5);
			gbc_lblXUpperLeft.gridx = 1;
			gbc_lblXUpperLeft.gridy = 0;
			contentPanel.add(lblXUpperLeft, gbc_lblXUpperLeft);
		}
		{
			textFieldX = new JTextField();
			GridBagConstraints gbc_textFieldX = new GridBagConstraints();
			gbc_textFieldX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX.gridx = 2;
			gbc_textFieldX.gridy = 0;
			contentPanel.add(textFieldX, gbc_textFieldX);
			textFieldX.setColumns(10);
		}
		{
			JLabel lblYUpperLeft = new JLabel("y cordinate upper left ");
			GridBagConstraints gbc_lblYUpperLeft = new GridBagConstraints();
			gbc_lblYUpperLeft.anchor = GridBagConstraints.EAST;
			gbc_lblYUpperLeft.insets = new Insets(0, 0, 5, 5);
			gbc_lblYUpperLeft.gridx = 1;
			gbc_lblYUpperLeft.gridy = 1;
			contentPanel.add(lblYUpperLeft, gbc_lblYUpperLeft);
		}
		{
			textFieldY = new JTextField();
			GridBagConstraints gbc_textFieldY = new GridBagConstraints();
			gbc_textFieldY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY.gridx = 2;
			gbc_textFieldY.gridy = 1;
			contentPanel.add(textFieldY, gbc_textFieldY);
			textFieldY.setColumns(10);
		}
		{
			JLabel lblHeight = new JLabel("Height");
			lblHeight.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.anchor = GridBagConstraints.EAST;
			gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeight.gridx = 1;
			gbc_lblHeight.gridy = 2;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			textFieldHeight = new JTextField();
			GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
			gbc_textFieldHeight.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldHeight.gridx = 2;
			gbc_textFieldHeight.gridy = 2;
			contentPanel.add(textFieldHeight, gbc_textFieldHeight);
			textFieldHeight.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Width");
			lblWidth.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.anchor = GridBagConstraints.EAST;
			gbc_lblWidth.insets = new Insets(0, 0, 0, 5);
			gbc_lblWidth.gridx = 1;
			gbc_lblWidth.gridy = 3;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			textFieldWidth = new JTextField();
			GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
			gbc_textFieldWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldWidth.gridx = 2;
			gbc_textFieldWidth.gridy = 3;
			contentPanel.add(textFieldWidth, gbc_textFieldWidth);
			textFieldWidth.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 if (textFieldX.getText().trim().isEmpty() || textFieldY.getText().trim().isEmpty() || textFieldHeight.getText().trim().isEmpty() || textFieldWidth.getText().trim().isEmpty()) {
		                        checkAll = false;
		                        setVisible(true);
		                        JOptionPane.showMessageDialog(null, "Please enter all values", "Error", JOptionPane.ERROR_MESSAGE);
		                    } else {
		                    	if ((Integer.parseInt(getTextFieldHeight().getText().trim()) < 0)) {
		                    		JOptionPane.showMessageDialog(contentPanel, "Height must be greater than 0", "Error", JOptionPane.ERROR_MESSAGE);
		                    	}
		                    	else if ((Integer.parseInt(getTextFieldWidth().getText().trim()) < 0)) {
		                    		JOptionPane.showMessageDialog(contentPanel, "Width must be greater than 0", "Error", JOptionPane.ERROR_MESSAGE);
		   
		                    	}
		                    	else {
		                    		checkAll = true;
		                    		setVisible(false);
		                    	}
		                    }
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTextFieldX() {
		return textFieldX;
	}

	public void setTextFieldX(JTextField textFieldX) {
		this.textFieldX = textFieldX;
	}

	public JTextField getTextFieldY() {
		return textFieldY;
	}

	public void setTextFieldY(JTextField textFieldY) {
		this.textFieldY = textFieldY;
	}

	public JTextField getTextFieldHeight() {
		return textFieldHeight;
	}

	public void setTextFieldHeight(JTextField textFieldHeight) {
		this.textFieldHeight = textFieldHeight;
	}

	public JTextField getTextFieldWidth() {
		return textFieldWidth;
	}

	public void setTextFieldWidth(JTextField textFieldWidth) {
		this.textFieldWidth = textFieldWidth;
	}
	

}

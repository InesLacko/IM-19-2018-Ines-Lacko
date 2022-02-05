package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class RectangleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldUpperLeftX;
	private JTextField textFieldHeight;
	private JTextField textFieldWidth;
	private Rectangle rectangle;
	private boolean checkAll;
	private JTextField textFieldUpperLeftY;
    private JColorChooser colorC;

	/**
	 * Create the dialog.
	 */
	public RectangleDialog() {
		setTitle("Lacko Ines IM 19/2018");
		setBounds(100, 100, 850, 550);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblUpperLeftX = new JLabel("UpperLeftX");
			lblUpperLeftX.setFont(new Font("Times New Roman", Font.BOLD, 12));
			GridBagConstraints gbc_lblUpperLeftX = new GridBagConstraints();
			gbc_lblUpperLeftX.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperLeftX.anchor = GridBagConstraints.SOUTHEAST;
			gbc_lblUpperLeftX.gridx = 0;
			gbc_lblUpperLeftX.gridy = 0;
			contentPanel.add(lblUpperLeftX, gbc_lblUpperLeftX);
		}
		{
			textFieldUpperLeftX = new JTextField();
			GridBagConstraints gbc_textFieldUpperLeftX = new GridBagConstraints();
			gbc_textFieldUpperLeftX.anchor = GridBagConstraints.SOUTH;
			gbc_textFieldUpperLeftX.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldUpperLeftX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldUpperLeftX.gridx = 1;
			gbc_textFieldUpperLeftX.gridy = 0;
			contentPanel.add(textFieldUpperLeftX, gbc_textFieldUpperLeftX);
			textFieldUpperLeftX.setColumns(10);
		}
		{
			JLabel lblUpperLeftY = new JLabel("UpperLeftY");
			lblUpperLeftY.setFont(new Font("Times New Roman", Font.BOLD, 12));
			GridBagConstraints gbc_lblUpperLeftY = new GridBagConstraints();
			gbc_lblUpperLeftY.anchor = GridBagConstraints.EAST;
			gbc_lblUpperLeftY.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperLeftY.gridx = 0;
			gbc_lblUpperLeftY.gridy = 1;
			contentPanel.add(lblUpperLeftY, gbc_lblUpperLeftY);
		}
		{
			textFieldUpperLeftY = new JTextField();
			GridBagConstraints gbc_textFieldUpperLeftY = new GridBagConstraints();
			gbc_textFieldUpperLeftY.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldUpperLeftY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldUpperLeftY.gridx = 1;
			gbc_textFieldUpperLeftY.gridy = 1;
			contentPanel.add(textFieldUpperLeftY, gbc_textFieldUpperLeftY);
			textFieldUpperLeftY.setColumns(10);
		}
		{
			JLabel lblHeight = new JLabel("Height");
			lblHeight.setFont(new Font("Times New Roman", Font.BOLD, 12));
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.anchor = GridBagConstraints.EAST;
			gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeight.gridx = 0;
			gbc_lblHeight.gridy = 2;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			textFieldHeight = new JTextField();
			GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
			gbc_textFieldHeight.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldHeight.gridx = 1;
			gbc_textFieldHeight.gridy = 2;
			contentPanel.add(textFieldHeight, gbc_textFieldHeight);
			textFieldHeight.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Width");
			lblWidth.setFont(new Font("Times New Roman", Font.BOLD, 12));
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.anchor = GridBagConstraints.EAST;
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 0;
			gbc_lblWidth.gridy = 3;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			textFieldWidth = new JTextField();
			GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
			gbc_textFieldWidth.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldWidth.gridx = 1;
			gbc_textFieldWidth.gridy = 3;
			contentPanel.add(textFieldWidth, gbc_textFieldWidth);
			textFieldWidth.setColumns(10);
		}
		{
			colorC = new JColorChooser();
			GridBagConstraints gbc_colorC = new GridBagConstraints();
			gbc_colorC.gridx = 2;
			gbc_colorC.gridy = 4;
			gbc_colorC.anchor = GridBagConstraints.NORTH;
			contentPanel.add(colorC, gbc_colorC);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				
						try {
							if(textFieldUpperLeftX.getText().trim().isEmpty() || textFieldUpperLeftY.getText().trim().isEmpty() || 
								textFieldHeight.getText().trim().isEmpty() || textFieldWidth.getText().trim().isEmpty()) {
								checkAll = false;
								JOptionPane.showMessageDialog(contentPanel, "All values must be entered!", "Error", JOptionPane.ERROR_MESSAGE);
							} 
							else {
								
								if((Integer.parseInt(textFieldUpperLeftX.getText().trim()) <= 0)) {
									JOptionPane.showMessageDialog(contentPanel, "X coordinate of the upper left point must be greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
								}
								else if((Integer.parseInt(textFieldUpperLeftY.getText().trim()) <= 0)){
									JOptionPane.showMessageDialog(contentPanel, "Y coordinate of the upper left point must be greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
								}
								else if((Integer.parseInt(textFieldHeight.getText().trim()) <= 0)){
									JOptionPane.showMessageDialog(contentPanel, "Height must be greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
								}
								else if((Integer.parseInt(textFieldWidth.getText().trim()) <= 0)){
									JOptionPane.showMessageDialog(contentPanel, "Width must be greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
								}
								else {
									checkAll = true;
									rectangle = new Rectangle(new Point(Integer.parseInt(textFieldUpperLeftX.getText()),
											Integer.parseInt(textFieldUpperLeftX.getText())),
											Integer.parseInt(textFieldHeight.getText()),
											Integer.parseInt(textFieldWidth.getText()),false);
									rectangle.setColor(colorC.getColor());
									setVisible(false);
								}
							}
						} 
						catch (NumberFormatException exception){
							JOptionPane.showMessageDialog(contentPanel, "Incorrect data type", "Error", JOptionPane.ERROR_MESSAGE);
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

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public JTextField getTextFieldUpperLeftX() {
		return textFieldUpperLeftX;
	}

	public void setTextFieldUpperLeftX(JTextField textFieldUpperLeftX) {
		this.textFieldUpperLeftX = textFieldUpperLeftX;
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

	public boolean isCheckAll() {
		return checkAll;
	}

	public void setCheckAll(boolean checkAll) {
		this.checkAll = checkAll;
	}

	public JTextField getTextFieldUpperLeftY() {
		return textFieldUpperLeftY;
	}

	public void setTextFieldUpperLeftY(JTextField textFieldUpperLeftY) {
		this.textFieldUpperLeftY = textFieldUpperLeftY;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

}

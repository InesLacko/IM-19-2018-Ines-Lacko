package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
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

public class CircleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCenterX;
	private JTextField textFieldRadius;
	private Circle circle;
	private boolean checkAll;
	private JTextField textFieldCenterY;
	private JColorChooser colorC;
	/**
	 * Create the dialog.
	 */
	public CircleDialog() {
		setTitle("Lacko Ines IM 19/2018");
		setBounds(100, 100, 850, 550);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCenterX = new JLabel("CenterX");
			GridBagConstraints gbc_lblCenterX = new GridBagConstraints();
			gbc_lblCenterX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterX.anchor = GridBagConstraints.EAST;
			gbc_lblCenterX.gridx = 0;
			gbc_lblCenterX.gridy = 0;
			contentPanel.add(lblCenterX, gbc_lblCenterX);
		}
		{
			textFieldCenterX = new JTextField();
			GridBagConstraints gbc_textFieldCenterX = new GridBagConstraints();
			gbc_textFieldCenterX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldCenterX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldCenterX.gridx = 1;
			gbc_textFieldCenterX.gridy = 0;
			contentPanel.add(textFieldCenterX, gbc_textFieldCenterX);
			textFieldCenterX.setColumns(10);
		}
		{
			JLabel lblCenterY = new JLabel("CenterY");
			GridBagConstraints gbc_lblCenterY = new GridBagConstraints();
			gbc_lblCenterY.anchor = GridBagConstraints.EAST;
			gbc_lblCenterY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterY.gridx = 0;
			gbc_lblCenterY.gridy = 1;
			contentPanel.add(lblCenterY, gbc_lblCenterY);
		}
		{
			textFieldCenterY = new JTextField();
			GridBagConstraints gbc_textFieldCenterY = new GridBagConstraints();
			gbc_textFieldCenterY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldCenterY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldCenterY.gridx = 1;
			gbc_textFieldCenterY.gridy = 1;
			contentPanel.add(textFieldCenterY, gbc_textFieldCenterY);
			textFieldCenterY.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Radius");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.insets = new Insets(0, 0, 0, 5);
			gbc_lblRadius.gridx = 0;
			gbc_lblRadius.gridy = 2;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			textFieldRadius = new JTextField();
			GridBagConstraints gbc_textFieldRadius = new GridBagConstraints();
			gbc_textFieldRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldRadius.gridx = 1;
			gbc_textFieldRadius.gridy = 2;
			contentPanel.add(textFieldRadius, gbc_textFieldRadius);
			textFieldRadius.setColumns(10);
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
							if(textFieldCenterX.getText().trim().isEmpty() || textFieldCenterY.getText().trim().isEmpty() || 
									textFieldRadius.getText().trim().isEmpty()) {
								checkAll = false;
								JOptionPane.showMessageDialog(contentPanel, "All values must be entered!", "Error", JOptionPane.ERROR_MESSAGE);
							} 
							else {
								
								if((Integer.parseInt(textFieldCenterX.getText().trim()) <= 0)) {
									JOptionPane.showMessageDialog(contentPanel, "X coordinate of the center must be greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
								}
								else if((Integer.parseInt(textFieldCenterY.getText().trim()) <= 0)){
									JOptionPane.showMessageDialog(contentPanel, "Y coordinate of the center must be greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
								}
								else if((Integer.parseInt(textFieldRadius.getText().trim()) <= 0)){
									JOptionPane.showMessageDialog(contentPanel, "Radius must be greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
								}
								else {
									checkAll = true;
									circle = new Circle(Integer.parseInt(textFieldRadius.getText()),new Point(Integer.parseInt(textFieldCenterX.getText()),
											Integer.parseInt(textFieldRadius.getText())),
											false);
									circle.setColor(colorC.getColor());
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

	public JTextField getTextFieldCenterX() {
		return textFieldCenterX;
	}

	public void setTextFieldCenterX(JTextField textFieldCenterX) {
		this.textFieldCenterX = textFieldCenterX;
	}

	public JTextField getTextFieldRadius() {
		return textFieldRadius;
	}

	public void setTextFieldRadius(JTextField textFieldRadius) {
		this.textFieldRadius = textFieldRadius;
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public boolean isCheckAll() {
		return checkAll;
	}

	public void setCheckAll(boolean checkAll) {
		this.checkAll = checkAll;
	}

	public JTextField getTextFieldCenterY() {
		return textFieldCenterY;
	}

	public void setTextFieldCenterY(JTextField textFieldCenterY) {
		this.textFieldCenterY = textFieldCenterY;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

}

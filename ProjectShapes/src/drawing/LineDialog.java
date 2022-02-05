package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import geometry.Point;
import javafx.scene.paint.Color;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LineDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldStartX;
	private JTextField textFieldStartY;
	private JTextField textFieldEndX;
	private JTextField textFieldEndY;
	private Line line;
	private boolean checkAll;
	private JColorChooser colorC;
	
	/**
	 * Create the dialog.
	 */
	public LineDialog() {
		setTitle("Lacko Ines IM 19/2018");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblStartX = new JLabel("StartX");
			GridBagConstraints gbc_lblStartX = new GridBagConstraints();
			gbc_lblStartX.anchor = GridBagConstraints.EAST;
			gbc_lblStartX.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartX.gridx = 0;
			gbc_lblStartX.gridy = 0;
			contentPanel.add(lblStartX, gbc_lblStartX);
		}
		{
			textFieldStartX = new JTextField();
			GridBagConstraints gbc_textFieldStartX = new GridBagConstraints();
			gbc_textFieldStartX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldStartX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldStartX.gridx = 1;
			gbc_textFieldStartX.gridy = 0;
			contentPanel.add(textFieldStartX, gbc_textFieldStartX);
			textFieldStartX.setColumns(10);
		}
		{
			JLabel lblStartY = new JLabel("StartY");
			GridBagConstraints gbc_lblStartY = new GridBagConstraints();
			gbc_lblStartY.anchor = GridBagConstraints.EAST;
			gbc_lblStartY.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartY.gridx = 0;
			gbc_lblStartY.gridy = 1;
			contentPanel.add(lblStartY, gbc_lblStartY);
		}
		{
			textFieldStartY = new JTextField();
			GridBagConstraints gbc_textFieldStartY = new GridBagConstraints();
			gbc_textFieldStartY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldStartY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldStartY.gridx = 1;
			gbc_textFieldStartY.gridy = 1;
			contentPanel.add(textFieldStartY, gbc_textFieldStartY);
			textFieldStartY.setColumns(10);
		}
		{
			JLabel lblEndX = new JLabel("EndX");
			GridBagConstraints gbc_lblEndX = new GridBagConstraints();
			gbc_lblEndX.anchor = GridBagConstraints.EAST;
			gbc_lblEndX.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndX.gridx = 0;
			gbc_lblEndX.gridy = 2;
			contentPanel.add(lblEndX, gbc_lblEndX);
		}
		{
			textFieldEndX = new JTextField();
			GridBagConstraints gbc_textFieldEndX = new GridBagConstraints();
			gbc_textFieldEndX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldEndX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldEndX.gridx = 1;
			gbc_textFieldEndX.gridy = 2;
			contentPanel.add(textFieldEndX, gbc_textFieldEndX);
			textFieldEndX.setColumns(10);
		}
		{
			JLabel lblEndY = new JLabel("EndY");
			GridBagConstraints gbc_lblEndY = new GridBagConstraints();
			gbc_lblEndY.anchor = GridBagConstraints.EAST;
			gbc_lblEndY.insets = new Insets(0, 0, 0, 5);
			gbc_lblEndY.gridx = 0;
			gbc_lblEndY.gridy = 3;
			contentPanel.add(lblEndY, gbc_lblEndY);
		}
		{
			textFieldEndY = new JTextField();
			GridBagConstraints gbc_textFieldEndY = new GridBagConstraints();
			gbc_textFieldEndY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldEndY.gridx = 1;
			gbc_textFieldEndY.gridy = 3;
			contentPanel.add(textFieldEndY, gbc_textFieldEndY);
			textFieldEndY.setColumns(10);
		}
		{
			colorC = new JColorChooser();
			contentPanel.add(colorC);
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
							if(textFieldStartX.getText().trim().isEmpty() || textFieldStartY.getText().trim().isEmpty() || 
								textFieldEndX.getText().trim().isEmpty() || textFieldEndY.getText().trim().isEmpty()) {
								checkAll = false;
								JOptionPane.showMessageDialog(contentPanel, "All values must be entered!", "Error", JOptionPane.ERROR_MESSAGE);
							} 
							else {
								
								if((Integer.parseInt(textFieldStartX.getText().trim()) <= 0)) {
									JOptionPane.showMessageDialog(contentPanel, "X coordinate of the start point must be greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
								}
								else if((Integer.parseInt(textFieldStartY.getText().trim()) <= 0)){
									JOptionPane.showMessageDialog(contentPanel, "Y coordinate of the start point must be greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
								}
								else if((Integer.parseInt(textFieldEndX.getText().trim()) <= 0)){
									JOptionPane.showMessageDialog(contentPanel, "X coordinate of the end point must be greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
								}
								else if((Integer.parseInt(textFieldEndY.getText().trim()) <= 0)){
									JOptionPane.showMessageDialog(contentPanel, "Y coordinate of the end point must be greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
								}
								else {
									checkAll = true;
									line = new Line(new Point(Integer.parseInt(textFieldStartX.getText()), Integer.parseInt(textFieldStartY.getText())),
											new Point(Integer.parseInt(textFieldEndX.getText()), Integer.parseInt(textFieldEndY.getText())),false);
									line.setColor(colorC.getColor());
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

	public JTextField getTextFieldStartX() {
		return textFieldStartX;
	}

	public void setTextFieldStartX(JTextField textFieldStartX) {
		this.textFieldStartX = textFieldStartX;
	}

	public JTextField getTextFieldStartY() {
		return textFieldStartY;
	}

	public void setTextFieldStartY(JTextField textFieldStartY) {
		this.textFieldStartY = textFieldStartY;
	}

	public JTextField getTextFieldEndX() {
		return textFieldEndX;
	}

	public void setTextFieldEndX(JTextField textFieldEndX) {
		this.textFieldEndX = textFieldEndX;
	}

	public JTextField getTextFieldEndY() {
		return textFieldEndY;
	}

	public void setTextFieldEndY(JTextField textFieldEndY) {
		this.textFieldEndY = textFieldEndY;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public boolean isCheckAll() {
		return checkAll;
	}

	public void setCheckAll(boolean checkAll) {
		this.checkAll = checkAll;
	}

	
	

}

package drawing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DrawingFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PnlDrawing panel = new PnlDrawing(DrawingFrame.this);
	private JPanel contentPane;
	private JToolBar toolBar;
	private JToggleButton tglbtnSelected,tglbtnPoint,tglbtnLine,tglbtnRectangle,tglbtnCircle,tglbtnDonut;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnModify;
	private JButton btnDelete;


	/**
	 * Create the frame.
	 */
	public DrawingFrame() {
		setTitle("Lacko Ines IM 19/2018");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		

		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		getContentPane().add(panel,BorderLayout.CENTER);
		
		 tglbtnSelected = new JToggleButton("Selected");
		 tglbtnSelected.setFont(new Font("Times New Roman", Font.BOLD, 15));
		toolBar.add(tglbtnSelected);
		buttonGroup.add(tglbtnSelected);
		
		 tglbtnPoint = new JToggleButton("Point");
		 tglbtnPoint.setFont(new Font("Times New Roman", Font.BOLD, 15));
		toolBar.add(tglbtnPoint);
		buttonGroup.add(tglbtnPoint);
		
		 tglbtnLine = new JToggleButton("Line");
		 tglbtnLine.setFont(new Font("Times New Roman", Font.BOLD, 15));
		toolBar.add(tglbtnLine);
		buttonGroup.add(tglbtnLine);
		
		tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.setFont(new Font("Times New Roman", Font.BOLD, 15));
		toolBar.add(tglbtnRectangle);
		buttonGroup.add(tglbtnRectangle);
		
		 tglbtnCircle = new JToggleButton("Circle");
		 tglbtnCircle.setFont(new Font("Times New Roman", Font.BOLD, 15));
		toolBar.add(tglbtnCircle);
		buttonGroup.add(tglbtnCircle);
		
		 tglbtnDonut = new JToggleButton("Donut");
		 tglbtnDonut.setFont(new Font("Times New Roman", Font.BOLD, 15));
		toolBar.add(tglbtnDonut);
		buttonGroup.add(tglbtnDonut);
		
		
		
	
		btnModify = new JButton("Modify");
		btnModify.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		modify();
			}
		});
		toolBar.add(btnModify);
	
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			delete();
			}
		});
		toolBar.add(btnDelete); 
		}
		
		protected void delete() {
			Shape selected = panel.getSelected();
			if (selected != null) {
				int response = JOptionPane.showConfirmDialog(panel, "Do you want to delete this element?", "Question",
						JOptionPane.YES_NO_OPTION);
				if (response == JOptionPane.YES_OPTION) {
					panel.getShapes().remove(selected);
					
				} else {
					return;
				}
			}
			panel.repaint();
		}
		
		protected void modify() {
			Shape selected = panel.getSelected();
			if (selected != null) {
				if (selected instanceof Point) {
					Point point = (Point) selected;
					PointDialog dialog = new PointDialog();

					dialog.getTextFieldX().setText(Integer.toString(point.getX()));
					dialog.getTextFieldY().setText(Integer.toString(point.getY()));

					dialog.setModal(true);
					dialog.setVisible(true);

					if (dialog.isCheckAll()) {
						panel.getShapes().remove(selected);
						panel.getShapes().add(dialog.getPoint());
					}
				} else if (selected instanceof Line) {
					Line line = (Line) selected;
					LineDialog dialog = new LineDialog();

					dialog.getTextFieldStartX().setText(Integer.toString(line.getStartPoint().getX()));
					dialog.getTextFieldStartY().setText(Integer.toString(line.getStartPoint().getY()));
					dialog.getTextFieldEndX().setText(Integer.toString(line.getEndPoint().getX()));
					dialog.getTextFieldEndY().setText(Integer.toString(line.getEndPoint().getY()));

					dialog.setModal(true);
					dialog.setVisible(true);

					if (dialog.isCheckAll()) {
						panel.getShapes().remove(selected);
						panel.getShapes().add(dialog.getLine());
					}
				} else if (selected instanceof Rectangle) {
					Rectangle rectangle = (Rectangle) selected;
					RectangleDialog dialog = new RectangleDialog();

					dialog.getTextFieldUpperLeftX().setText(Integer.toString(rectangle.getUpperLeft().getX()));
					dialog.getTextFieldUpperLeftY().setText(Integer.toString(rectangle.getUpperLeft().getY()));
					dialog.getTextFieldHeight().setText(Integer.toString(rectangle.getHeight()));
					dialog.getTextFieldWidth().setText(Integer.toString(rectangle.getWidth()));

					dialog.setModal(true);
					dialog.setVisible(true);

					if (dialog.isCheckAll()) {
						panel.getShapes().remove(selected);
						panel.getShapes().add(dialog.getRectangle());
					}
				} else if (selected instanceof Circle) {
					Circle circle = (Circle) selected;
					CircleDialog dialog = new CircleDialog();

					dialog.getTextFieldCenterX().setText(Integer.toString(circle.getCenter().getX()));
					dialog.getTextFieldCenterY().setText(Integer.toString(circle.getCenter().getY()));
					dialog.getTextFieldRadius().setText(Integer.toString(circle.getRadius()));

					dialog.setModal(true);
					dialog.setVisible(true);

					if (dialog.isCheckAll()) {
						panel.getShapes().remove(selected);
						panel.getShapes().add(dialog.getCircle());
					}
				} else if (selected instanceof Donut) {
					Donut donut = (Donut) selected;
					DonutDialog dialog = new DonutDialog();

					dialog.getTextFieldCenterX().setText(Integer.toString(donut.getCenter().getX()));
					dialog.getTextFieldCenterY().setText(Integer.toString(donut.getCenter().getY()));
					dialog.getTextFieldRadius().setText(Integer.toString(donut.getRadius()));
					dialog.getTextFieldInnerRadius().setText(Integer.toString(donut.getInnerRadius()));

					dialog.setModal(true);
					dialog.setVisible(true);

					if (dialog.isCheckAll()) {
						panel.getShapes().remove(selected);
						panel.getShapes().add(dialog.getDonut());
					}
				}
			}
			panel.repaint();
		}
		

	public PnlDrawing getPanel() {
		return panel;
	}

	public void setPanel(PnlDrawing panel) {
		this.panel = panel;
	}

	public JToggleButton getTglbtnSelected() {
		return tglbtnSelected;
	}

	public void setTglbtnSelected(JToggleButton tglbtnSelected) {
		this.tglbtnSelected = tglbtnSelected;
	}

	public JToggleButton getTglbtnPoint() {
		return tglbtnPoint;
	}

	public void setTglbtnPoint(JToggleButton tglbtnPoint) {
		this.tglbtnPoint = tglbtnPoint;
	}

	public JToggleButton getTglbtnLine() {
		return tglbtnLine;
	}

	public void setTglbtnLine(JToggleButton tglbtnLine) {
		this.tglbtnLine = tglbtnLine;
	}

	public JToggleButton getTglbtnRectangle() {
		return tglbtnRectangle;
	}

	public void setTglbtnRectangle(JToggleButton tglbtnRectangle) {
		this.tglbtnRectangle = tglbtnRectangle;
	}

	public JToggleButton getTglbtnCircle() {
		return tglbtnCircle;
	}

	public void setTglbtnCircle(JToggleButton tglbtnCircle) {
		this.tglbtnCircle = tglbtnCircle;
	}

	public JToggleButton getTglbtnDonut() {
		return tglbtnDonut;
	}

	public void setTglbtnDonut(JToggleButton tglbtnDonut) {
		this.tglbtnDonut = tglbtnDonut;
	}

	
	}

package drawing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;

public class DrawingFrame extends JFrame {

	private JPanel contentPane;
	private JToggleButton tglbtnCircle,tglbtnPoint,tglbtnLine,tglbtnRectangle,tglbtnDonut;
	private JToggleButton tglbtnSelected;
	private JPanel panel_1;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingFrame frame = new DrawingFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DrawingFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		 
		 tglbtnSelected = new JToggleButton("Selected");
		 panel.add(tglbtnSelected);
		
		 tglbtnCircle = new JToggleButton("Circle");
		panel.add(tglbtnCircle);
		
		 tglbtnLine = new JToggleButton("Line");
		panel.add(tglbtnLine);
		
		 tglbtnPoint = new JToggleButton("Point");
		panel.add(tglbtnPoint);
		
		 tglbtnRectangle = new JToggleButton("Rectangle");
		panel.add(tglbtnRectangle);
		
		 tglbtnDonut = new JToggleButton("Donut");
		panel.add(tglbtnDonut);
		
		PnlDrawing df = new PnlDrawing(DrawingFrame.this);
		add(df);
		
	}

	public JToggleButton getTglbtnCircle() {
		return tglbtnCircle;
	}

	public JToggleButton getTglbtnPoint() {
		return tglbtnPoint;
	}

	public JToggleButton getTglbtnLine() {
		return tglbtnLine;
	}

	public JToggleButton getTglbtnRectangle() {
		return tglbtnRectangle;
	}

	public JToggleButton getTglbtnDonut() {
		return tglbtnDonut;
	}

	public JToggleButton getTglbtnSelected() {
		return tglbtnSelected;
	}

	

}

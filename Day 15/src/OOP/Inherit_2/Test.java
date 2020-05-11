package OOP.Inherit_2;

public class Test {
	public static void main(String[] args) {
		Sample s = new Sample();
//		s.setSize(500, 200); > JFrame
//		s.setVisible(true); > JFrame
//		s.showOpenDialog(null); > JFileChooser
		s.showDialog(null, null, null);
	}
}

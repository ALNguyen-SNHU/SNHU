import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TopFiveDestinationList {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TopDestinationListFrame topDestinationListFrame = new TopDestinationListFrame();
                topDestinationListFrame.setTitle("Top 5 Destination List");
                topDestinationListFrame.setVisible(true);
            }
        });
    }
}


class TopDestinationListFrame extends JFrame {
    private DefaultListModel listModel;

    public TopDestinationListFrame() {
        super("Top Five Destination List");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 750);

        listModel = new DefaultListModel();


        //Make updates to your top 5 list below. Import the new image files to resources directory.
        // Added destinations: Cologne Cathedral, Ho Chi Minh City, St. Lucia, Yokohama Chinatown, and Miami Florida along with short descriptions.
        // Added images of each destination.
        // Indented code for readability.
        // (I also added a Miami Scarface joke image at the end.)

        // https://commons.wikimedia.org/wiki/File:Exterior_of_Cologne_Cathedral-.jpg
        // "Exterior of Cologne Cathedral" - By: Yair-haklai - On Wikimedia Commons (Creative Commons Attribution-Share Alike 4.0)
        addDestinationNameAndPicture("1. Top Destination: Cologne Cathedral (Kölner Dom) - A stunning Gothic masterpiece and one of the largest cathedrals in Europe. A landmark recognized by the United Nations Educational, Scientific and Cultural Organization.", new ImageIcon(getClass().getResource("/resources/cologne.jpg")));
        
        // https://commons.wikimedia.org/wiki/File:Ho_Chi_Minh_City,_Ho_Chi_Minh_Statue,_2020-01_CN-04.jpg
        // "Ho Chi Minh City, Ho Chi Minh Statue, 2020-01 CN-04" - By: Steffen Schmitz - On Wikimedia Commons (Creative Commons Attribution-Share Alike 4.0)
        addDestinationNameAndPicture("2. 2nd Top Destination: Ho Chi Minh City (hò̤ tɕǐ mīŋ) - Modern skyscrapers with a mix of French colonial architecture and the location of historic war memorials.", new ImageIcon(getClass().getResource("/resources/Ho_Chi_Minh.jpg")));
        
        // https://commons.wikimedia.org/wiki/File:Yachts,_Marigot_Bay,_St._Lucia.jpg
        // "Yachts, Marigot Bay, St. Lucia" - By: ImagePerson (Unknown user?) - On Wikimedia Commons (Creative Commons Attribution-Share Alike 4.0)
        addDestinationNameAndPicture("3. 3rd Top Destination: St. Lucia - An island in the Caribbean known for volcanic beaches, crystal clear water, luxury resorts, rain forests, and many outdoor activities.", new ImageIcon(getClass().getResource("/resources/St_Lucia.jpg")));
        
        // https://commons.wikimedia.org/wiki/File:Yokohama_Chinatown_Zenrimon_Gate_1.jpg
        // "Zenrimon Gate at the China Town, Yokohama, Kanagawa Prefecture, Kanto Region, Japan" - By: Zairon - On Wikimedia Commons (Creative Commons Attribution-Share Alike 4.0)
        addDestinationNameAndPicture("4. 4th Top Destination: Yokohama Chinatown (Japan) - The largest Chinatown in Japan. Where the restaurants are as traditional as the food is authentic. Annual festivals, vibrant colorful streets, architecture, and a culture hub for the Chinese heritage.", new ImageIcon(getClass().getResource("/resources/yokohama.jpg")));
        
        // https://commons.wikimedia.org/wiki/File:Miami-Florida09.JPG
        // "Miami, Florida USA" By: Diego Delso - On Wikimedia Commons (Creative Commons Attribution-Share Alike 4.0)
        addDestinationNameAndPicture("5. 5th Top Destination: Miami, Florida - A literal hotspot known for more than just its heat. Entertainment, luxury, beaches, electrifying nightlife, all with a blend of Cuban influences.", new ImageIcon(getClass().getResource("/resources/miami.jpg")));
        // This one is a joke. It does not come from wiki commons.
        addDestinationNameAndPicture("Miami again. (No this is a joke).", new ImageIcon(getClass().getResource("/resources/donut.jpg")));
        
        JList list = new JList(listModel);
        JScrollPane scrollPane = new JScrollPane(list);

        TextAndIconListCellRenderer renderer = new TextAndIconListCellRenderer(2);

        list.setCellRenderer(renderer);

        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Adding my name to the bottom of the frame horizontal scroll bar.
        JLabel nameLabel = new JLabel("Created by Andrew Nguyen");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(nameLabel, BorderLayout.SOUTH);

        // Customization background color for frame:
        Color skyBlue = new Color(135, 206, 235); // custom sky color

        getContentPane().setBackground(skyBlue);  // sets window background
        list.setBackground(skyBlue);              // sets list background to match
        
        list.setFont(new Font("SansSerif", Font.BOLD, 14));
    }

    private void addDestinationNameAndPicture(String text, Icon icon) {
        TextAndIcon tai = new TextAndIcon(text, icon);
        listModel.addElement(tai);
    }
}


class TextAndIcon {
    private String text;
    private Icon icon;

    public TextAndIcon(String text, Icon icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}


class TextAndIconListCellRenderer extends JLabel implements ListCellRenderer {
    private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);

    private Border insideBorder;

    public TextAndIconListCellRenderer() {
        this(0, 0, 0, 0);
    }

    public TextAndIconListCellRenderer(int padding) {
        this(padding, padding, padding, padding);
    }

    public TextAndIconListCellRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
        insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value,
    int index, boolean isSelected, boolean hasFocus) {
        // The object from the combo box model MUST be a TextAndIcon.
        TextAndIcon tai = (TextAndIcon) value;

        // Sets text and icon on 'this' JLabel.
        setText(tai.getText());
        setIcon(tai.getIcon());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        Border outsideBorder;

        if (hasFocus) {
            outsideBorder = UIManager.getBorder("List.focusCellHighlightBorder");
        } else {
            outsideBorder = NO_FOCUS_BORDER;
        }

        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        setComponentOrientation(list.getComponentOrientation());
        setEnabled(list.isEnabled());
        setFont(list.getFont());

        return this;
    }

    // The following methods are overridden to be empty for performance
    // reasons. If you want to understand better why, please read:
    //
    // http://java.sun.com/javase/6/docs/api/javax/swing/DefaultListCellRenderer.html#override

    public void validate() {}
    public void invalidate() {}
    public void repaint() {}
    public void revalidate() {}
    public void repaint(long tm, int x, int y, int width, int height) {}
    public void repaint(Rectangle r) {}
}
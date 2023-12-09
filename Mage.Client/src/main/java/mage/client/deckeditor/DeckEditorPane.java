package mage.client.deckeditor;

import mage.cards.decks.Deck;
import mage.client.MagePane;
import mage.client.constants.Constants.DeckEditorMode;
import mage.client.plugins.impl.Plugins;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * GUI: deck editor, used all around the app
 *
 * @author BetaSteward_at_googlemail.com
 */
public class DeckEditorPane extends MagePane {

    private UUID tableId = null;

    public DeckEditorPane() {
        boolean initialized = false;
        if (Plugins.instance.isThemePluginLoaded()) {
            Map<String, JComponent> uiMap = new HashMap<>();
            JComponent container = Plugins.instance.updateTablePanel(uiMap);
            if (container != null) {
                deckEditorPanel1 = new mage.client.deckeditor.DeckEditorPanel();
                initComponents(container);
                container.add(deckEditorPanel1);
                container.setOpaque(false);
                deckEditorPanel1.setOpaque(false);
                initialized = true;
            }
        }
        if (!initialized) {
            initComponents();
        }
    }

    @Override
    public void changeGUISize() {
        super.changeGUISize();
        deckEditorPanel1.changeGUISize();
    }

    public void show(DeckEditorMode mode, Deck deck, String name, UUID tableId, int visibleTimer) {
        this.tableId = tableId;
        this.setTitle(name);
        this.deckEditorPanel1.showDeckEditor(mode, deck, tableId, visibleTimer);
        this.repaint();
    }

    @Override
    public boolean isActiveTable() {
        return this.tableId != null;
    }

    public DeckEditorMode getDeckEditorMode() {
        return this.deckEditorPanel1.getDeckEditorMode();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deckEditorPanel1 = new mage.client.deckeditor.DeckEditorPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 32767));

        deckEditorPanel1.setMinimumSize(new java.awt.Dimension(1000, 500));
        getContentPane().add(deckEditorPanel1, java.awt.BorderLayout.CENTER);
        getContentPane().add(filler1, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void initComponents(Component container) {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );

    }

    public DeckEditorPanel getPanel() {
        return deckEditorPanel1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private mage.client.deckeditor.DeckEditorPanel deckEditorPanel1;
    private javax.swing.Box.Filler filler1;
    // End of variables declaration//GEN-END:variables

}

package com.xk72.charles.gui.transaction.popups;

import com.xk72.charles.gui.find.AdvancedFindDialog;
import com.xk72.charles.gui.session.popups.TransactionPopupMenu;
import com.xk72.charles.gui.navigator.a;
import com.xk72.charles.gui.session.y;
import com.xk72.charles.gui.transaction.actions.Base64DecodeAction$Text;
import com.xk72.charles.gui.transaction.actions.Base64DecodeAction$TextComponent;
import com.xk72.charles.gui.transaction.actions.CopyToClipboardAction$Text;
import com.xk72.charles.gui.transaction.actions.CopyToClipboardAction$TextComponent;
import com.xk72.charles.model.Transaction;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.text.JTextComponent;

public class TransactionViewerPopupMenu extends TransactionPopupMenu {
   public TransactionViewerPopupMenu(Transaction var1) {
      super(var1, (a)null, (y)null, (AdvancedFindDialog)null);
   }

   protected void prepare(MouseEvent var1) {
      Component var2;
      if ((var2 = (Component)var1.getSource()) instanceof JTable) {
         JTable var3 = (JTable)var2;
         Point var5 = var1.getPoint();
         int var4 = var3.rowAtPoint(var5);
         int var6 = var3.columnAtPoint(var5);
         Object var7;
         if (var4 >= 0 && var6 >= 0 && (var7 = var3.getValueAt(var4, var6)) != null) {
            this.add(new CopyToClipboardAction$Text(var7.toString()));
            if (var7 instanceof String) {
               this.add(new Base64DecodeAction$Text((String)var7, var2));
               this.add(new CharlesUrlDecodeText((String)var7, var2));
               this.add(new BPDecodeText((String)var7, var2));
            }

            this.addSeparator();
         }
      } else if (var2 instanceof JTextComponent) {
         this.add(new CopyToClipboardAction$TextComponent((JTextComponent)var2));
         this.add(new Base64DecodeAction$TextComponent((JTextComponent)var2));
         this.add(new CharlesUrlDecodeTextComponent((JTextComponent)var2));
         this.add(new BPDecodeTextComponent((JTextComponent)var2));
         this.addSeparator();
      }

      super.prepare(false);
   }
}

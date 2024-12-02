@echo off
::将你需要的添加进jar包的文件写到下面
::修改你需要更改的charles.jar包的地址，后面路径不需要改动
jar -uf E:/charles.jar com/xk72/charles/gui/transaction/popups/CharlesUrlDecode.class
jar -uf E:/charles.jar com/xk72/charles/gui/transaction/popups/CharlesUrlDecodeText.class
jar -uf E:/charles.jar com/xk72/charles/gui/transaction/popups/TransactionViewerPopupMenu.class
jar -uf E:/charles.jar com/xk72/charles/gui/transaction/popups/CharlesUrlDecodeTextComponent.class
jar -uf E:/charles.jar com/xk72/charles/gui/transaction/popups/HttpUtils.class
jar -uf E:/charles.jar com/xk72/charles/gui/transaction/popups/JsonUtils.class
jar -uf E:/charles.jar com/xk72/charles/gui/transaction/popups/ResultDialog.class
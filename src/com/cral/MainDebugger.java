package com.cral;

import org.mozilla.javascript.tools.debugger.Main;
import org.mozilla.javascript.tools.shell.Global;

public class MainDebugger {

    public static void main(String[] args) {
        Main main = new Main("Rhino JavaScript Debugger");
        main.doBreak();
       // main.setExitAction(new Main.IProxy(Main.IProxy.EXIT_ACTION));

        System.setIn(main.getIn());
        System.setOut(main.getOut());
        System.setErr(main.getErr());

        Global global = org.mozilla.javascript.tools.shell.Main.getGlobal();
        global.setIn(main.getIn());
        global.setOut(main.getOut());
        global.setErr(main.getErr());

        main.attachTo(
                org.mozilla.javascript.tools.shell.Main.shellContextFactory);

        main.setScope(global);

        main.pack();
        main.setSize(600, 460);
        main.setVisible(true);

        org.mozilla.javascript.tools.shell.Main.exec(args);
    }
}

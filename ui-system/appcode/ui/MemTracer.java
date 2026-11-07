package appcode.ui;

import java.awt.Color;
import com.rsc_games.velocity.util.Transform;
import com.rsc_games.velocity.sprite.ui.AnchorPoint;
import com.rsc_games.velocity.sprite.ui.UIText;

public class MemTracer extends UIText {
    long heapAvail;
    long totalHeap;

    public MemTracer(AnchorPoint anchor, Transform transform, String name, Color c) {
        super(anchor, transform, name, "Serif", c);
        this.transform.setZOrder(1);
        this.heapAvail = 0L;
        this.totalHeap = 0L;
    }

    public void onTick() {
        Runtime rt = Runtime.getRuntime();

        this.totalHeap = rt.totalMemory();
        this.heapAvail = this.totalHeap - rt.freeMemory();

        this.text = genHeapUsedStr();
    }

    private String genHeapUsedStr() {
        return "Memory (Avail/Total): " + (this.heapAvail / 1048576) + " / " + 
            (this.totalHeap / 1048576) + " MB (" + (this.heapAvail * 100 / this.totalHeap) + "%)";
    }

}

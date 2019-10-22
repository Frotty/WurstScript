package de.peeeq.wurstio.jassinterpreter.providers;

import de.peeeq.wurstio.jassinterpreter.mocks.RectMock;
import de.peeeq.wurstscript.intermediatelang.ILconstReal;
import de.peeeq.wurstscript.intermediatelang.IlConstHandle;
import de.peeeq.wurstscript.intermediatelang.interpreter.AbstractInterpreter;

public class RectProvider extends Provider {


    public RectProvider(AbstractInterpreter interpreter) {
        super(interpreter);
    }

    public IlConstHandle Rect(ILconstReal minx, ILconstReal miny, ILconstReal maxx, ILconstReal maxy) {
        return new IlConstHandle(NameProvider.getRandomName("rect"), new RectMock(minx, miny, maxx, maxy));
    }

    public void RemoveRect(IlConstHandle rect) {
    }

    public ILconstReal GetRectCenterX(IlConstHandle rect) {
        RectMock rectMock = (RectMock) rect.getObj();
        return new ILconstReal((rectMock.maxx.getVal() - rectMock.minx.getVal()) / 2.0);
    }

    public ILconstReal GetRectCenterY(IlConstHandle rect) {
        RectMock rectMock = (RectMock) rect.getObj();
        return new ILconstReal((rectMock.maxy.getVal() - rectMock.miny.getVal()) / 2.0);
    }

    public ILconstReal GetRectMinX(IlConstHandle rect) {
        RectMock rectMock = (RectMock) rect.getObj();
        return rectMock.minx;
    }

    public ILconstReal GetRectMinY(IlConstHandle rect) {
        RectMock rectMock = (RectMock) rect.getObj();
        return rectMock.miny;
    }

    public ILconstReal GetRectMaxX(IlConstHandle rect) {
        RectMock rectMock = (RectMock) rect.getObj();
        return rectMock.maxx;
    }

    public ILconstReal GetRectMaxY(IlConstHandle rect) {
        RectMock rectMock = (RectMock) rect.getObj();
        return rectMock.maxy;
    }

    public void SetRect(IlConstHandle rect, ILconstReal minx, ILconstReal miny, ILconstReal maxx, ILconstReal maxy) {
        RectMock rectMock = (RectMock) rect.getObj();
        rectMock.maxx = maxx;
        rectMock.maxy = maxy;
        rectMock.minx = minx;
        rectMock.miny = miny;
    }

    public void MoveRectTo(IlConstHandle rect, ILconstReal newCenterX, ILconstReal newCenterY) {
        RectMock rectMock = (RectMock) rect.getObj();
        rectMock.minx = new ILconstReal(newCenterX.getVal() - (rectMock.getWidth() / 2.));
        rectMock.maxx = new ILconstReal(newCenterX.getVal() + (rectMock.getWidth() / 2.));
        rectMock.miny = new ILconstReal(newCenterY.getVal() - (rectMock.getHeight() / 2.));
        rectMock.maxy = new ILconstReal(newCenterY.getVal() + (rectMock.getHeight() / 2.));
    }
}

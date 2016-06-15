package game;

import java.io.Serializable;
import java.util.List;

import view.ViewListener;

public interface View extends Serializable {

        void showView();

        void showPresentation();

        void showLobbs(List<Lobb> lobbs);

        Lobb chooseLobb(List<Lobb> lobbs);

        void showError(Throwable e);

        void addListener(ViewListener viewListener);

        void startedLobb();

        public String requestName();

        public void paint(Canvas canvas);

}

package com.colony.buildings;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.buildings.abst.EdificioFabbrica;
import com.colony.buildings.actors.Agent;
import com.colony.buildings.actors.Mission;
import com.colony.buildings.actors.Transporter;
import com.colony.commons.Anagrafica;
import com.colony.commons.NotifyFromAgent;
import com.colony.commons.OrdersHub;
import com.colony.commons.Ordine;
import com.colony.commons.Pacco;
import com.colony.commons.TrasporterHub;
import com.colony.enums.Materiale;
import com.colony.enums.TipoElemento;

public class Castello extends EdificioFabbrica implements NotifyFromAgent {

	private int numTrasporters = 10;

	public Castello(float x, float y, Stage s, BaseActor act) {
		super(x, y, s, act, "Castello");

		tipoElemento = TipoElemento.CASTELLO;

		materiPrimeInGiacenza.addMateriale(Materiale.TRONCO, 50);
		materiPrimeInGiacenza.addMateriale(Materiale.ASSE_LEGNO, 50);
		materiPrimeInGiacenza.addMateriale(Materiale.ACQUA, 50);

	}

	@Override
	public void work() {
		setMilestone();
		
		processOrders();

		processTrasports();
	}

	private void processTrasports() {
		if (numTrasporters == 0)
			return;
		Pacco p = TrasporterHub.getPacco();
		if (p == null)
			return;

		Transporter tran = new Transporter(this, mainStage, TipoElemento.TRANSPORTER);

		boolean started = tran.startMission(p.getPartenza(), p.getDestinazione());
		if (started) {
			numTrasporters--;
		} else {
			TrasporterHub.setPacco(p);
		}

	}

	@Override
	protected void processOrders() {
		Materiale[] mats = Materiale.values();

		for (int i = 0; i < mats.length; i++)
			process(mats[i]);

	}

	private void process(Materiale m) {
		if (materiPrimeInGiacenza.getGiacenzaMateriale(m) > 0) {
			Ordine o = OrdersHub.getOrdine(m);
			if (o != null) {

				inviaProdotto(o);
				materiPrimeInGiacenza.removeMateriale(m);
			}
		}
	}

//	protected void pinviaProdotto(Ordine o) {
//		materiPrimeInGiacenza.removeMateriale(o.getMateriale());
//		Edificio target = Anagrafica.getActorById(o.getIdEdificio());
//
//		Agent agent = new Agent(getX(), getY(), mainStage, this);
//
//		agent.goMission(target.getX(), target.getY(), new Mission() {
//
//			@Override
//			public void exec() {
//				target.handleDelivery(o);
//
//			}
//		});
//
//	}

	@Override
	public void notifyMissionComplete() {
		// TODO Auto-generated method stub

	}

}

package org.example;

public enum TipoFrete {
	NORMAL{
		@Override
		public Frete obterFrete() {
			return new Normal();
		}
	},
	SEDEX{
		@Override
		public Frete obterFrete() {
			return new Sedex();
		}
	},
	SEDEX10{
		@Override
		public Frete obterFrete() {
			return new Sedex10();
		}
	};
	public abstract Frete obterFrete();
}

package com.whiterabbit.bondi.client.maps;

import java.util.List;

import com.whiterabbit.bondi.shared.dto.Position;

public interface PositionResolverCallback {

	void onCallback(List<Position> locations);

	void onNoResults();

	void onError();

}

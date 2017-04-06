/*
 * Copyright 2015 Taylor Caldwell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.rithms.riot.constant;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotStringNotFoundException;

public enum Platform {
	BR("BR1", "br"),
	EUNE("EUN1", "eune"),
	EUW("EUW1", "euw"),
	JP("JP1", "jp"),
	KR("KR", "kr"),
	LAN("LA1", "lan"),
	LAS("LA2", "las"),
	NA("NA1", "na"),
	OCE("OC1", "oce"),
	PBE("PBE1", "pbe"),
	RU("RU", "ru"),
	TR("TR1", "tr");

	private String id;
	private String name;

	public static Platform getPlatformByName(String name) throws RiotStringNotFoundException {
		for (Platform platform : Platform.values()) {
			if (platform.getName().equals(name.toLowerCase())) {
				return platform;
			}
		}
		RiotApi.log.warning("Unknown region: " + name);
		throw new RiotStringNotFoundException("Could not find region " + name);
	}

	Platform(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getHost() {
		return "https://" + getId().toLowerCase() + ".api.riotgames.com";
	}

	@Override
	public String toString() {
		return getName();
	}
}
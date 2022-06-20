package fun.bb1.registry;

import java.util.Collection;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 
 * Copyright 2022 BradBot_1
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * An interface implemented by any registry
 * 
 * @author BradBot_1
 */
public interface IRegistry<K, T> {
	
	public @Nullable T register(final @NotNull K identifier, final @NotNull T registree);
	
	public @Nullable T get(final @NotNull K identifier);
	
	public @Nullable T unregister(final @NotNull K identifier);
	
	public boolean contains(final @NotNull K identifier);
	
	default void onRegister(final @NotNull K identifier, final @NotNull T registree) { }
	
	public @NotNull Collection<K> getAllKeys();
	
	public @NotNull Collection<T> getAllValues();
	
}

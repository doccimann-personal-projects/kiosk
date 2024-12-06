package com.example.kiosk.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

abstract public class Model {
    protected final long id;
    protected final CellType type;

    public Model(long id, CellType type) {
        this.id = id;
        this.type = type;
    }

    public static DiffUtil.ItemCallback<Model> DIFF_CALLBACK() {
        return new DiffUtil.ItemCallback<Model>() {
            @Override
            public boolean areItemsTheSame(@NonNull Model oldItem, @NonNull Model newItem) {
                return oldItem.id == newItem.id && oldItem.type == newItem.type;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Model oldItem, @NonNull Model newItem) {
                // 객체의 내용이 동일한지 비교
                return oldItem.equals(newItem);
            }
        };
    }

    public long getId() {
        return id;
    }

    public CellType getType() {
        return type;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Model model = (Model) obj;

        return id == model.id && type == model.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }
}

package com.example.kiosk.extension;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

public class ImageViewExtension {
    // fade-in, fade-out의 애니메이션을 처리하기 위한 factory
    private static final DrawableCrossFadeFactory factory = new DrawableCrossFadeFactory.Builder()
            .setCrossFadeEnabled(true)
            .build();
    private ImageViewExtension() {
    }

    // ImageView clear
    public static void clear(ImageView imageView) {
        Glide.with(imageView)
                .clear(imageView);
    }

    public static void load(ImageView imageView, String url, float corner, Transformation<Bitmap> scaleType) {
        RequestBuilder<Drawable> imageViewLoadBuilder = Glide.with(imageView)
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade(factory))
                .diskCacheStrategy(DiskCacheStrategy.ALL);

        if (corner > 0) {
            imageViewLoadBuilder = imageViewLoadBuilder.transform(scaleType, new RoundedCorners(FloatExtension.fromDpToPx(corner)));
        }

        imageViewLoadBuilder.into(imageView);
    }

    public static void loadDefault(ImageView imageView, String url, float corner) {
        load(imageView, url, corner, new CenterInside());
    }
}

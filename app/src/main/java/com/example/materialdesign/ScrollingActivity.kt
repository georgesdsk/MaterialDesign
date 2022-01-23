package com.example.materialdesign

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.materialdesign.databinding.ActivityScrollingBinding
import com.google.android.material.bottomappbar.BottomAppBar

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root);

        /**
         * 1. viewBinding
         */

        binding.fab.setOnClickListener {
            if (binding.bottomAppBar.fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER) {
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            } else {
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            }
        }

        /**
         *  2. Boton inferior para que muestre notificacion
         */
        binding.bottomAppBar.setOnClickListener {
            Snackbar.make(it, R.string.app_name, Snackbar.LENGTH_LONG) //
                .setAnchorView(binding.fab)
                .setAction(R.string.escribe_puto, {
                    Toast.makeText(this, R.string.app_name, Toast.LENGTH_SHORT).show() // muestra una tostada
                })
                .show()
        }



        binding.content.tbNombre2?.onFocusChangeListener = View.OnFocusChangeListener {view, focused ->

            var srcImagen: String = binding.content.tbNombre.toString();
            /**
             * 3. Cargador de imagenes
             */

            if (!focused){
                Snackbar.make(binding.root,"char secuencia", Snackbar.LENGTH_SHORT)
                    .setAnchorView(binding.fab)
                    .show()
               Glide.with(this)
                   .load(srcImagen)
                   .diskCacheStrategy(DiskCacheStrategy.ALL) // guarda el tamanio de la foto
                   .centerCrop()
                   .into(binding.content.imgCard!!)
            }else{

                Snackbar.make(binding.root,"godeeeer", Snackbar.LENGTH_SHORT)

            }
        }






    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
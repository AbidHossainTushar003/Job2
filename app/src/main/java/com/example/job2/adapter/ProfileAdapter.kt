package com.example.job2.adapter


import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.example.job2.R
import com.example.job2.data.model.UserProfile
import com.example.job2.databinding.ItemProfileBinding


/**
 * Adapter for the RecyclerView to display a list of [UserProfile] entities.
 * Inherits from [ListAdapter] to handle list diffing on a background thread.
 *
 * @property onEditClick Callback function triggered when the edit button is clicked.
 * @property onDeleteClick Callback function triggered when the delete button is clicked.
 * @property onProfileClick Callback function triggered when a profile item is clicked.
 */
class ProfileAdapter(

    private val onEditClick:(UserProfile)->Unit,

    private val onDeleteClick:(UserProfile)->Unit,

    private val onProfileClick:(UserProfile)->Unit,


): ListAdapter<UserProfile, ProfileAdapter.ProfileViewHolder>(DiffCallback) {




    /**
     * Creates a new [ProfileViewHolder] when the RecyclerView needs one.
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileViewHolder {


        val binding =
            ItemProfileBinding.inflate(

                LayoutInflater.from(parent.context),

                parent,

                false

            )


        return ProfileViewHolder(binding)

    }




    /**
     * Binds the data at the specified position to the [holder].
     */
    override fun onBindViewHolder(
        holder: ProfileViewHolder,
        position: Int
    ) {


        holder.bind(
            getItem(position)
        )


    }






    /**
     * ViewHolder for profile items in the RecyclerView.
     *
     * @property binding The binding object for the item layout.
     */
    inner class ProfileViewHolder(

        private val binding:ItemProfileBinding

    ):RecyclerView.ViewHolder(binding.root){


        /**
         * Binds a [UserProfile] to the views in the item layout.
         *
         * @param profile The user profile to display.
         */
        fun bind(
            profile:UserProfile
        ){
            val context = binding.root.context

            binding.txtName.text =
                context.getString(R.string.display_name, profile.name)



            binding.txtEmail.text =
                context.getString(R.string.display_email, profile.email)



            binding.txtMobile.text =
                context.getString(R.string.display_mobile, profile.mobile)





            binding.btnEdit.setOnClickListener {


                onEditClick(profile)


            }





            binding.btnDelete.setOnClickListener {


                onDeleteClick(profile)


            }






            binding.root.setOnClickListener {


                onProfileClick(profile)


            }



        }


    }




    /**
     * Callback for calculating the diff between two non-null items in a list.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<UserProfile>() {

        /**
         * Checks whether two objects represent the same item.
         */
        override fun areItemsTheSame(
            oldItem: UserProfile,
            newItem: UserProfile,
        ): Boolean {

            return oldItem.id == newItem.id

        }


        /**
         * Checks whether two items have the same data.
         */
        override fun areContentsTheSame(
            oldItem: UserProfile,
            newItem: UserProfile,
        ): Boolean {

            return oldItem == newItem

        }

    }



}

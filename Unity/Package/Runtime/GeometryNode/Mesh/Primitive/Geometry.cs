using UnityEngine;

namespace JervNorsk.Tool.GeometryNode.Mesh.Primitive
{
    public abstract class Geometry : MonoBehaviour
    {
        protected virtual void InitAttributes() { }

        protected virtual void UpdateAttributes() { }

        [HideInInspector]
        public UnityEngine.Mesh mesh;

        [HideInInspector]
        public UnityEngine.MeshFilter meshFilter;

        [HideInInspector]
        public UnityEngine.MeshRenderer meshRenderer;

        protected virtual void InitComponents()
        {
            InitMesh();
            InitMeshFilter();
            InitMeshRenderer();
        }

        protected virtual void UpdateComponents()
        {
            UpdateMesh();
        }

        protected virtual void InitMesh()
        {
            if (mesh == null)
            {
                mesh = new UnityEngine.Mesh();
            }
        }
        protected abstract void UpdateMesh();

        protected virtual void InitMeshFilter()
        {
            meshFilter = gameObject.GetComponent<UnityEngine.MeshFilter>();

            if (meshFilter == null)
            {
                meshFilter = gameObject.AddComponent<UnityEngine.MeshFilter>();

            }

            meshFilter.sharedMesh = mesh;
        }

        protected virtual void InitMeshRenderer()
        {
            meshRenderer = gameObject.GetComponent<UnityEngine.MeshRenderer>();

            if (meshRenderer == null)
            {
                meshRenderer = gameObject.AddComponent<UnityEngine.MeshRenderer>();
            }
        }

        public virtual void Reset()
        {
            Debug.Log("Reset");

            InitAttributes();
            InitComponents();
        }

        public virtual void FixedUpdate()
        {
            Debug.Log("FixedUpdate");

            UpdateAttributes();
            UpdateComponents();
        }
    }
}